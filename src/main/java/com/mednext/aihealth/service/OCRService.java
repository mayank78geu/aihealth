package com.mednext.aihealth.service;

import org.springframework.stereotype.Service;

@Service
public class OCRService {

    public String extract(String path) {
        System.out.println("📄 OCR processing on: " + path);
        return "Hemoglobin: 11.2 g/dL\nGlucose - 160 mg/dL\nWBC: 8000\nPlatelets: 150000";
    }
}