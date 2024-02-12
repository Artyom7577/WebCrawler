package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class WebCrawler implements Runnable {
    private static final int MAX_DEPTH = 3;
    private final String firstLink;
    private final ArrayList<String> visitedLinks = new ArrayList<>();
    private final int ID;
    private final Thread thread;

    public WebCrawler(String link, int num) {
        this.firstLink = link;
        this.ID = num;

        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        crawl(1, firstLink);
    }

    private void crawl(int level, String url) {
        if (level <= MAX_DEPTH) {
            Document document = request(url);
            if (document != null) {
                for (Element link : document.select("a[href]")) {
                    String nextLink = link.absUrl("href");
                    if (!visitedLinks.contains(nextLink)) {
                        crawl(level++, nextLink);
                    }
                }
            }
        }
    }

    private Document request(String url) {
        try {
            Connection connection = Jsoup.connect(url);
            Document doc = connection.get();

            if (connection.response().statusCode() == 200) {
                System.out.println("ID: " + ID + " Received Webpage at " + url);

                String title = doc.title();
                System.out.println(title);
                visitedLinks.add(url);

                return doc;
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    public Thread getThread() {
        return thread;
    }
}
