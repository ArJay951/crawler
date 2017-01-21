package sample.arjay.crawler;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {
	public static void main(String[] args) throws IOException {

		File file = new File("D:/stock/1216201603.html");

		Document doc = Jsoup.parse(file, null);
		Elements elements = doc.select("td");
		elements.forEach(element -> System.out.println(element));
	}
}
