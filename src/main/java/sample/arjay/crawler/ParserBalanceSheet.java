package sample.arjay.crawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.client.RestTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

import sample.arjay.pojo.BalanceSheet;
import sample.arjay.pojo.Daily;

public class ParserBalanceSheet {

	public static MongoClient mongoClient() {
		return new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017)),
				MongoClientOptions.builder().readPreference(ReadPreference.primaryPreferred()).connectionsPerHost(30)
						.writeConcern(WriteConcern.ACKNOWLEDGED).build());
	}

	public static void main(String[] args) throws InterruptedException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MongoTemplate template = new MongoTemplate(Parser.mongoClient(), "stock");

		List<Daily> daliys = template.findAll(Daily.class);

		List<String> codes = new ArrayList<>(daliys.parallelStream()
				.filter(daily -> daily.getSecurityCode().length() == 4 && !daily.getSecurityCode().startsWith("0"))
				.map(Daily::getSecurityCode).collect(Collectors.toSet()));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

		codes.sort((s1, s2) -> s1.compareTo(s2));
		codes = codes.subList(0, 20);

		BalanceSheet bs;
		StringBuilder sb = new StringBuilder();

		sb.append("股票代號,");
		sb.append("現金及約當現金,");
		sb.append("透過損益按公允價值衡量之金融資產－流動,");
		sb.append("備供出售金融資產－流動淨額,");
		sb.append("持有至到期日金融資產－流動淨額,");
		sb.append("避險之衍生金融資產－流動,");
		sb.append("非流動負債合計,");
		sb.append("普通股股本,");
		sb.append("發行張數,");
		sb.append("現金淨值,");
		sb.append("股價,");
		sb.append("現金淨值比,");
		sb.append("營業收入合計,");
		sb.append("營業毛利（毛損）淨額,");
		sb.append("毛利率,");
		sb.append("營業利益（損失）,");
		sb.append("營業利益率,");
		sb.append("去年同期營業利益率,");
		sb.append("營業利益成長率,");
		sb.append("營業外收入及支出合計,");
		sb.append("業外收入比率,");
		sb.append("繼續營業單位本期淨利（淨損）,");
		sb.append("繼續營業單位淨利（淨損）,");
		sb.append("稀釋每股盈餘,");
		sb.append("本益比,");
		sb.append("修正後本益比,");
		sb.append("資料修正日期,");
		sb.append("季別\r\n");

		for (String code : codes) {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("encodeURIComponent", "1");
			map.add("step", "1");
			map.add("firstin", "1");
			map.add("off", "1");
			map.add("keyword4", "");
			map.add("TYPEK2", "");
			map.add("checkbtn", "");
			map.add("queryName", "co_id");
			map.add("inpuType", "co_id");
			map.add("TYPEK", "all");
			map.add("isnew", "true");
			map.add("co_id", code);
			map.add("year", "");
			map.add("season", "");

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
					headers);

			String response = restTemplate.postForObject("http://mops.twse.com.tw/mops/web/ajax_t164sb03", request,
					String.class);

			bs = new BalanceSheet();
			bs.setStockCode(code);
			Document doc = Jsoup.parse(response);
			Elements rows = doc.select("tr");
			for (Element row : rows) {
				Elements tds = row.select("td");
				if (tds.size() >= 2) {
					parseTd(bs, tds.get(0).text().replaceAll("[　 ]", ""), tds.get(1).text().trim().replaceAll(",", ""));
				}
			}

			response = restTemplate.postForObject("http://mops.twse.com.tw/mops/web/ajax_t164sb04", request,
					String.class);
			doc = Jsoup.parse(response);
			rows = doc.select("tr");
			for (Element row : rows) {
				Elements tds = row.select("td");
				if (tds.size() >= 2) {
					parseTd(bs, tds.get(0).text().replaceAll("[　 ]", ""), tds.get(1).text().trim().replaceAll(",", ""));
				}
			}
			System.out.println(bs.toCsv());
			sb.append(bs.toCsv());
			sb.append(System.getProperty("line.separator"));
			Thread.sleep(1000);
		}

		File outputFile = new File("C:/Users/ASUS/Documents/stock/test.csv");
		try (FileChannel fileChannel = new FileOutputStream(outputFile).getChannel()) {
			String text = sb.toString();
			byte[] byteData = text.toString().getBytes("UTF-8");
			ByteBuffer buffer = ByteBuffer.wrap(byteData);
			fileChannel.write(buffer);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public static void parseTd(BalanceSheet bs, String field, String field2) {
		// System.out.println("field:" + field + " field2:" + field2);
		if ("現金及約當現金".equals(field)) {
			bs.setCashEquivalents(field2);
		} else if ("透過損益按公允價值衡量之金融資產－流動".equals(field)) {
			bs.setCfafv(field2);
		} else if ("備供出售金融資產－流動淨額".equals(field)) {
			bs.setAfiac(field2);
		} else if ("持有至到期日金融資產－流動淨額".equals(field)) {
			bs.setHfia(field2);
		} else if ("避險之衍生金融資產－流動".equals(field)) {
			bs.setDfafh(field2);
		} else if ("非流動負債合計".equals(field)) {
			bs.setNoncurrentAssets(field2);
		} else if ("普通股股本".equals(field)) {
			bs.setOrdinaryShare(field2);
		} else if ("股價".equals(field)) {
			bs.setStockPrice(field2);
		} else if ("營業收入合計".equals(field)) {
			bs.setOperatingRevenue(field2);
		} else if ("營業毛利（毛損）淨額".equals(field)) {
			bs.setGrossProfitLossFromOperationsNet(field2);
		} else if ("毛利率".equals(field)) {
			bs.setGrossMargin(field2);
		} else if ("營業利益（損失）".equals(field)) {
			bs.setNetOperatingIncomeLoss(field2);
		} else if ("營業利益率".equals(field)) {
			bs.setNetOperatingIncomeLossRate(field2);
		} else if ("去年同期營業利益率".equals(field)) {
			bs.setLastOperatingProfitRate(field2);
		} else if ("營業外收入及支出合計".equals(field)) {
			bs.setOperatingProfitGrowthRate(field2);
		} else if ("繼續營業單位本期淨利（淨損）".equals(field)) {
			bs.setProfitLossFromContinuingOperationsRate(field2);
		} else if ("稀釋每股盈餘".equals(field)) {
			bs.setDilutedEarningsLossPerShare(field2);
		}
	}
}
