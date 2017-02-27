package sample.arjay.crawler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

import sample.arjay.pojo.Daily;

public class Parser {
	public static MongoClient mongoClient() {
		return new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017)),
				MongoClientOptions.builder().readPreference(ReadPreference.primaryPreferred()).connectionsPerHost(30)
						.writeConcern(WriteConcern.ACKNOWLEDGED).build());
	}

	public static void main(String[] args) throws IOException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MongoTemplate template = new MongoTemplate(Parser.mongoClient(), "stock");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

		Calendar cal = Calendar.getInstance(Locale.TAIWAN);
		cal.set(2017, 0, 24);

		for (int day = 0; day < 120; day++) {
			try {
				cal.add(Calendar.DATE, -1);
				String date = String.format("%d/%02d/%02d", (Integer.valueOf(cal.get(Calendar.YEAR)) - 1911),
						Integer.valueOf(cal.get(Calendar.MONTH)) + 1, Integer.valueOf(cal.get(Calendar.DATE)));
				System.out.println("crawler date:" + date);
				MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
				map.add("qdate", date);
				map.add("selectType", "ALLBUT0999");
				// map.add("download", "csv");

				HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
						headers);

				String response = restTemplate.postForObject(
						"http://www.tse.com.tw/ch/trading/exchange/MI_INDEX/MI_INDEX.php", request, String.class);

				Document doc = Jsoup.parse(response);

				Element table = doc.select("table").get(1);
				Elements rows = table.select("tr");
				Daily daily;
				for (int i = 2; i < rows.size(); i++) {
					Element row = rows.get(i);
					daily = new Daily();
					Elements tds = row.select("td");
					daily.setId(date + "_" + tds.get(0).text());
					daily.setDate(cal.getTime());
					daily.setSecurityCode(tds.get(0).text());
					daily.setStockName(tds.get(1).text());
					daily.setTradeVolume(Long.valueOf(tds.get(2).text().replaceAll(",", "")));
					daily.setTransaction(Integer.valueOf(tds.get(3).text().replaceAll(",", "")));
					daily.setTradeValue(Long.valueOf(
							StringUtils.isEmpty(tds.get(4).text()) ? "0" : tds.get(4).text().replaceAll(",", "")));
					daily.setOpeningPrice(Double.valueOf(tds.get(5).text().replaceAll("--", "0").replaceAll(",", "")));
					daily.setHighestPrice(Double.valueOf(tds.get(6).text().replaceAll("--", "0").replaceAll(",", "")));
					daily.setLowestPrice(Double.valueOf(tds.get(7).text().replaceAll("--", "0").replaceAll(",", "")));
					daily.setClosingPrice(Double.valueOf(tds.get(8).text().replaceAll("--", "0").replaceAll(",", "")));
					daily.setDir(tds.get(9).text());
					daily.setChange(Double.valueOf(tds.get(10).text().replaceAll("--", "0").replaceAll(",", "")));
					daily.setLastBestBidPrice(
							Double.valueOf(tds.get(11).text().replaceAll("--", "0").replaceAll(",", "")));
					daily.setLastBestBidVolume(Long.valueOf(
							StringUtils.isEmpty(tds.get(12).text()) ? "0" : tds.get(12).text().replaceAll(",", "")));
					daily.setLastBestAskPrice(
							Double.valueOf(tds.get(13).text().replaceAll("--", "0").replaceAll(",", "")));
					daily.setLastBestAskVolume(Long.valueOf(
							StringUtils.isEmpty(tds.get(14).text()) ? "0" : tds.get(14).text().replaceAll(",", "")));
					daily.setPrice_EarningRatio(
							Double.valueOf(tds.get(15).text().replaceAll("--", "0").replaceAll(",", "")));
					template.save(daily);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("程式結束");
	}
}
