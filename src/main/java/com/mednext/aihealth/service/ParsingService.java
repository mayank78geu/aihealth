package com.mednext.aihealth.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ParsingService {

    public Map<String, Float> extractParameters(String text) {
        System.out.println("🧠 Parsing text: " + text);
        return Map.of(
                "Hemoglobin", 10f,
                "Glucose", 150f
        );
    }
}