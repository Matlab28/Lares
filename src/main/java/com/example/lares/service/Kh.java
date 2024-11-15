package com.example.lares.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Kh {
    public static void main(String[] args) throws IOException {
            Document blocks = Jsoup.connect("https://kontakt.az/notbuk-ve-kompyuterler/komputerler/monobloklar").get();
            Elements contentos = blocks.getElementsByClass("contentos");
            Elements links = contentos.select("a[href^=https://kontakt.az/notbuk-ve-kompyuterler/komputerler/monobloklar]");

            for (Element link : links) {
                String href = link.attr("href");
                System.out.println(href);
//                if (!dto.getLinks().contains(href)) {
//                    log.info("New link - " + href);
//                } else {
//                    log.warn("Duplicate link - " + href);
//                }
            }
    }
}


/*

public boolean monoBlocks(CategoryRequestDto dto) {
        try {
            Document blocks = Jsoup.connect("https://kontakt.az/notbuk-ve-kompyuterler/komputerler/monobloklar").get();
            Elements contentos = blocks.getElementsByClass("contentos");
            Elements links = contentos.select("a[href^=" + dto.getLinks() + "]");

            for (Element link : links) {
                String href = link.attr("href");
                if (!dto.getLinks().contains(href)) {
                    log.info("New link - " + href);
                } else {
                    log.warn("Duplicate link - " + href);
                }
            }
        } catch (IOException e) {
            log.error("Something went wrong...");
            return false;
        }
        return true;
    }

public void compare(CategoryRequestDto dto) {
        CategoryEntity map = modelMapper.map(dto, CategoryEntity.class);

        boolean result = phones(dto) || notebooks(dto) || airConditioners(dto) || smartWatches(dto)
                || smartBands(dto) || headphones(dto) || monoBlocks(dto) || tvs(dto) || tablets(dto)
                || fridges(dto) || oven(dto) || vacuums(dto);


        if (result) {
            categoryRepository.save(map);
            log.info("Customer's choice matches and saved in DB.");
        } else {
            log.error("Customer's choice doesn't match.");
        }
    }


    public boolean vacuums(CategoryRequestDto dto) {
        return scrapeCategory("https://kontakt.az/meiset-texnikasi/ev-texnikasi/ev-ucun-xirda-texnika/tozsoranlar?p=", dto, 3);
    }

 */