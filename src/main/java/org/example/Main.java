package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<WebCrawler> bots = new ArrayList<>();
        bots.add(new WebCrawler("your link here", 1));

        for (WebCrawler bot : bots) {
            try{
                bot.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}