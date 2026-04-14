package com.mednext.aihealth.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ParsingService {

    public Map<String, Float> extractParameters(String text) {

        text = cleanText(text);

        Map<String, Float> result = new HashMap<>();

        // Hemoglobin
        extractValue(text, "(hemoglobin|hb)\\s*[:\\-]?\\s*(\\d+\\.?\\d*)", "Hemoglobin", result);

        // Glucose
        extractValue(text, "(glucose|sugar)\\s*[:\\-]?\\s*(\\d+\\.?\\d*)", "Glucose", result);

        // WBC
        extractValue(text, "(wbc)\\s*[:\\-]?\\s*(\\d+\\.?\\d*)", "WBC", result);

        // RBC
        extractValue(text, "(rbc)\\s*[:\\-]?\\s*(\\d+\\.?\\d*)", "RBC", result);

        // Platelets
        extractValue(text, "(platelets|plt)\\s*[:\\-]?\\s*(\\d+\\.?\\d*)", "Platelets", result);

        return result;
    }

    private void extractValue(String text, String regex, String key, Map<String, Float> result) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            try {
                Float value = Float.parseFloat(matcher.group(2));
                result.put(key, value);
            } catch (Exception ignored) {}
        }
    }

    private String cleanText(String text) {
        return text
                .replaceAll("[^a-zA-Z0-9:\\.\\-\\s]", " ")
                .replaceAll("\\s+", " ")
                .toLowerCase();
    }
}