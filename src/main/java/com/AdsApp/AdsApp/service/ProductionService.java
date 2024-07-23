package com.AdsApp.AdsApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdsApp.AdsApp.entity.Production;
import com.AdsApp.AdsApp.repository.ProductionRepository;

@Service
public class ProductionService {

    @Autowired
    private ProductionRepository productionRepository;

    public Production saveFilePath(String filePath) {
        Production production = new Production();
        production.setFilePath(filePath);
        return productionRepository.save(production);
    }
}