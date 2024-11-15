//package com.example.lares.config;
//
//import feign.RequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FeignConfig {
//
//    @Bean
//    public RequestInterceptor headerInterceptor() {
//        return template -> {
//            template.header("x-rapidapi-key", "e927e99e5fmshc26acad97b4c4dfp1bfc27jsna5a7036bb30e");
//            template.header("x-rapidapi-host", "google-news13.p.rapidapi.com");
//            System.out.println(template);
//            @Configuration
//            public class FeignConfig {
//
//                @Bean
//                public RequestInterceptor headerInterceptor() {
//                    return template -> {
//                        template.header("x-rapidapi-key", "e927e99e5fmshc26acad97b4c4dfp1bfc27jsna5a7036bb30e");
//                        template.header("x-rapidapi-host", "google-news13.p.rapidapi.com");
//                        System.out.println(template.url());
//                    };
//                }
//            }
//        }
//    }
