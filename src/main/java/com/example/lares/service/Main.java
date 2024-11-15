package com.example.lares.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("https://turbo.az/autos?q%5Bsort%5D=&q%5Bmake%5D%5B%5D=9&q%5Bmodel%5D%5B%5D=&q%5Bused%5D=&q%5Bregion%5D%5B%5D=&q%5Bprice_from%5D=&q%5Bprice_to%5D=&q%5Bcurrency%5D=azn&q%5Bloan%5D=0&q%5Bbarter%5D=0&q%5Bcategory%5D%5B%5D=&q%5Byear_from%5D=&q%5Byear_to%5D=&q%5Bcolor%5D%5B%5D=&q%5Bfuel_type%5D%5B%5D=&q%5Bgear%5D%5B%5D=&q%5Btransmission%5D%5B%5D=&q%5Bengine_volume_from%5D=&q%5Bengine_volume_to%5D=&q%5Bpower_from%5D=&q%5Bpower_to%5D=&q%5Bmileage_from%5D=&q%5Bmileage_to%5D=&q%5Bonly_shops%5D=&q%5Bprior_owners_count%5D%5B%5D=&q%5Bseats_count%5D%5B%5D=&q%5Bmarket%5D%5B%5D=&q%5Bcrashed%5D=1&q%5Bpainted%5D=1&q%5Bfor_spare_parts%5D=0&q%5Bavailability_status%5D=").get();
        Document document = Jsoup.connect("https://turbo.az/autos/8919450-bmw-520").get();
//        Elements contentos = document.getElementsByClass("products products--featured js-import-container");

        Elements contentos = document.getElementsByClass("product-properties tz-d-flex tz-justify-between tz-gap-10");


        for (Element item : contentos) {
            Elements contentos1 = item.getElementsByClass("product-properties__column");
            System.out.println(contentos1);


            //products-i__name
//            Elements name = item.getElementsByClass("products-i__name");
//            System.out.println("======================================================");
//            Elements element1 = item.getElementsByClass("products-i__attributes products-i__bottom-text");
//            System.out.println(element1.html());

//            System.out.println(name.html() + element1.html());

        }
    }
}

/*
   public void wef() throws IOException {
        String link = "https://turbo.az/autos?q%5Bsort%5D=&q%5Bmake%5D%5B%5D=86&q%5Bmodel%5D%5B%5D=&q%5Bused%5D=&q%5Bregion%5D%5B%5D=&q%5Bprice_from%5D=&q%5Bprice_to%5D=&q%5Bcurrency%5D=azn&q%5Bloan%5D=0&q%5Bbarter%5D=0&q%5Bcategory%5D%5B%5D=&q%5Byear_from%5D=&q%5Byear_to%5D=&q%5Bcolor%5D%5B%5D=&q%5Bfuel_type%5D%5B%5D=&q%5Bgear%5D%5B%5D=&q%5Btransmission%5D%5B%5D=&q%5Bengine_volume_from%5D=&q%5Bengine_volume_to%5D=&q%5Bpower_from%5D=&q%5Bpower_to%5D=&q%5Bmileage_from%5D=&q%5Bmileage_to%5D=&q%5Bonly_shops%5D=&q%5Bprior_owners_count%5D%5B%5D=&q%5Bseats_count%5D%5B%5D=&q%5Bmarket%5D%5B%5D=&q%5Bcrashed%5D=1&q%5Bpainted%5D=1&q%5Bfor_spare_parts%5D=0&q%5Bavailability_status%5D=";
 //       Document document = Jsoup.connect("https://turbo.az/autos?q%5Bsort%5D=&q%5Bmake%5D%5B%5D=3&q%5Bmodel%5D%5B%5D=&q%5Bused%5D=&q%5Bregion%5D%5B%5D=&q%5Bprice_from%5D=&q%5Bprice_to%5D=&q%5Bcurrency%5D=azn&q%5Bloan%5D=0&q%5Bbarter%5D=0&q%5Bcategory%5D%5B%5D=&q%5Byear_from%5D=&q%5Byear_to%5D=&q%5Bcolor%5D%5B%5D=&q%5Bfuel_type%5D%5B%5D=&q%5Bgear%5D%5B%5D=&q%5Btransmission%5D%5B%5D=&q%5Bengine_volume_from%5D=&q%5Bengine_volume_to%5D=&q%5Bpower_from%5D=&q%5Bpower_to%5D=&q%5Bmileage_from%5D=&q%5Bmileage_to%5D=&q%5Bonly_shops%5D=&q%5Bprior_owners_count%5D%5B%5D=&q%5Bseats_count%5D%5B%5D=&q%5Bmarket%5D%5B%5D=&q%5Bcrashed%5D=1&q%5Bpainted%5D=1&q%5Bfor_spare_parts%5D=0&q%5Bavailability_status%5D=").get();
        Document document = Jsoup.connect(link).get();
        Elements contentos = document.getElementsByClass("products");

        for (Element element : contentos) {
//            Element element1 = element.getElementsByClass("products-i__name products-i__bottom-text").get(0);
            Elements element1 = element.getElementsByClass("products-i__name");
            System.out.println(element1.html());

//            System.out.println(element.text());
//            log.info("Product Name: {}", element1.text());
//            log.info("salam");

//            System.out.println("salam");
        }
    }
 */