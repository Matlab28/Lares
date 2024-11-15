package com.example.lares.controller;


import com.example.lares.service.SalesReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class SalesReportController {

    private final SalesReportService salesReportService;

    @GetMapping("/generate")
    public String generateReport() {
        salesReportService.generateAndLogReport();
        return "Report generated and logged to console!";
    }
}
