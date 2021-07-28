package com.pavan.controller;

import java.util.ArrayList;
import java.util.List;

import com.pavan.dto.ExcelDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/excel")
public class ExcelDataController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/uploadData")
    public ResponseEntity<List<ExcelDataDto>> addExcelData(@RequestBody List<ExcelDataDto> data) {
        String apiUrl = "http://COMPANY-SERVICE/company/addStockPrices";
        List<ExcelDataDto> failedInserts = restTemplate.postForEntity(apiUrl, data, ArrayList.class).getBody();
        if(failedInserts.size() == 0) {
            return ResponseEntity.ok(failedInserts);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failedInserts);
        }
    }
}
