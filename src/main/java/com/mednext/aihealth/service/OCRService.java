package com.mednext.aihealth.service;

import org.springframework.stereotype.Service;

@Service
public class OCRService {

    public String extract(String path) {
        System.out.println("📄 OCR processing on: " + path);
        return "Hemoglobin: 10 Glucose: 150";
    }
}