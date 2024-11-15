//package com.example.lares.service;
//
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AsyncService {
//
//    @Async("taskExecutor")  // Specifies the executor to use for this method
////    @Scheduled(fixedDelay = 5000)
//    public void performAsyncTask() {
//        System.out.println("Starting async task in thread: " + Thread.currentThread().getName());
//
//        try {
//            // Simulate a long-running task (e.g., processing, sending emails, etc.)
//            Thread.sleep(3000);  // Sleep for 3 seconds to simulate delay
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Completed async task in thread: " + Thread.currentThread().getName());
//    }
//}
