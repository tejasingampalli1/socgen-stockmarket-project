package com.pavan.controller;

import java.util.List;

import com.pavan.dto.ExcelDataDTO;
import com.pavan.entity.StockPrice;
import com.pavan.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/company")
public class StockPriceController {
    @Autowired
    private StockPriceService stockPriceService;

    @GetMapping("/getStockPrices")
    public ResponseEntity<List<StockPrice>> getAllStockPrices(){
        return ResponseEntity.ok(stockPriceService.getAllStockPrices());
    }

    @PostMapping("/addStockPrices")
    public ResponseEntity<List<ExcelDataDTO>> addStockPrices(@RequestBody List<ExcelDataDTO> data){
        return ResponseEntity.ok(stockPriceService.addStockPrices(data));
    }

    @GetMapping("/getStockPrices/{companyId}/{exchangeId}/{before}/{after}")
    public ResponseEntity<List<StockPrice>> getStockPricesByCompany(@PathVariable(value = "companyId") int companyId,
                                                                    @PathVariable(value = "exchangeId") int exchangeId,
                                                                    @PathVariable(value = "before") String before,
                                                                    @PathVariable(value = "after") String after){
        return ResponseEntity.ok(stockPriceService.getStockPriceByCompany(companyId, exchangeId, before, after));
    }

}