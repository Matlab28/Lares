package com.example.lares.service;


import com.example.lares.dto.SalesDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class SalesReportService {

    // Schedule task to run every Monday at 9 AM
    @Scheduled(cron = "0 0 9 * * MON")
    public void generateAndLogReport() {
        List<SalesDto> salesList = getSalesData();
        StringBuilder reportBuilder = new StringBuilder("Weekly Sales Report:\n");
        reportBuilder.append("Generated at: ").append(LocalDateTime.now()).append("\n");
        reportBuilder.append("Product Name | Total Sales\n");
        reportBuilder.append("--------------------------\n");

        for (SalesDto sale : salesList) {
            reportBuilder.append(sale.getProductName()).append(" | ")
                    .append(sale.getSalesAmount()).append("\n");
        }

        System.out.println(reportBuilder);
    }

    private List<SalesDto> getSalesData() {
        return Arrays.asList(
                new SalesDto("Product A", 150.0),
                new SalesDto("Product B", 200.0),
                new SalesDto("Product C", 300.0)
        );
    }
}
