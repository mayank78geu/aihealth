package com.mednext.aihealth.service;

import com.mednext.aihealth.entity.Report;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AnalysisService {

    public void process(Map<String, Float> values, Report report) {
        System.out.println("📊 Analyzing values: " + values);
    }
}