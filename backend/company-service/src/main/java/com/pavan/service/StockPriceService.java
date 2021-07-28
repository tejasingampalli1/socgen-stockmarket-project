package com.pavan.service;

import java.util.ArrayList;
import java.util.List;

import com.pavan.dto.ExcelDataDTO;
import com.pavan.entity.StockPrice;
import com.pavan.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;

    public List<StockPrice> getAllStockPrices() {
        return stockPriceRepository.findAll();
    }

    public List<ExcelDataDTO> addStockPrices(List<ExcelDataDTO> excelData){
        List<ExcelDataDTO> failedInserts = new ArrayList<>();
        for(ExcelDataDTO data:excelData) {
            try {
                stockPriceRepository.addStockPrice(data.getCompanyId(), data.getExchangeId(), data.getPrice(), data.getTimestamp());
            } catch(Exception e) {
                failedInserts.add(data);
            }
        }
        return failedInserts;
    }

    public List<StockPrice> getStockPriceByCompany(int companyId, int exchangeId, String before, String after){
        return stockPriceRepository.getStockPricesByCompany(companyId, exchangeId, before, after);
    }

}