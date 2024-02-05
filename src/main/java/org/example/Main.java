package org.example;

import java.util.ArrayList;

public class Main {

//    public static void main(String[] args) {
//        ArrayList<WebCrawler> bots = new ArrayList<>();
//        bots.add(new WebCrawler("http://192.168.44.125:7415/api/users/", 1));
//
//        for (WebCrawler bot : bots) {
//            try{
//                bot.getThread().join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
        String apiEndpoint = "http://192.168.44.125:7415/api/users/";

        WebCrawlerForDb crawler = new WebCrawlerForDb(apiEndpoint, 1);

        try {
            crawler.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("User Data Collection Completed.");
    }
}