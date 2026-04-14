package com.mednext.aihealth.service;

import com.mednext.aihealth.entity.*;
import com.mednext.aihealth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AnalysisService {

    @Autowired private ParameterRepository parameterRepo;
    @Autowired private ReportParameterRepository reportParamRepo;
    @Autowired private AnalysisResultRepository resultRepo;
    @Autowired private ReferenceRangeRepository rangeRepo;

    public void process(Map<String, Float> values, Report report) {

        for (Map.Entry<String, Float> entry : values.entrySet()) {

            String paramName = entry.getKey();
            Float value = entry.getValue();

            // 1. Get parameter from master
            MedicalParameter param = parameterRepo.findByParamName(paramName)
                    .orElseGet(() -> {
                        MedicalParameter newParam = new MedicalParameter();
                        newParam.setParamName(paramName);
                        newParam.setUnit("unit"); // temporary
                        return parameterRepo.save(newParam);
                    });

            // 2. Save report parameter
            ReportParameter rp = new ReportParameter();
            rp.setReport(report);
            rp.setParameter(param);
            rp.setValue(value);
            reportParamRepo.save(rp);

            // 3. Get reference range
            ReferenceRange range = rangeRepo.findAll()
                    .stream()
                    .filter(r -> r.getParameter().getParamId().equals(param.getParamId()))
                    .findFirst()
                    .orElse(null);

            Status status = Status.NORMAL;
            RiskLevel risk = RiskLevel.LOW;

            if (range != null) {
                if (value < range.getMinValue()) {
                    status = Status.LOW;
                    risk = RiskLevel.MODERATE;
                } else if (value > range.getMaxValue()) {
                    status = Status.HIGH;
                    risk = RiskLevel.HIGH;
                }
            }

            // 4. Save analysis result
            AnalysisResult result = new AnalysisResult();
            result.setReport(report);
            result.setParameter(param);
            result.setStatus(status);
            result.setRiskLevel(risk);

            resultRepo.save(result);
        }
    }
}