package com.mednext.aihealth.orchestrator;

import com.mednext.aihealth.entity.Report;
import com.mednext.aihealth.entity.ReportStatus;
import com.mednext.aihealth.repository.ReportRepository;
import com.mednext.aihealth.service.AnalysisService;
import com.mednext.aihealth.service.OCRService;
import com.mednext.aihealth.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReportOrchestrator {

    @Autowired private OCRService ocrService;
    @Autowired private ParsingService parsingService;
    @Autowired private AnalysisService analysisService;
    @Autowired private ReportRepository reportRepo;

    @Async
    public void processReport(Report report) {

        try {
            report.setStatus(ReportStatus.PROCESSING);
            reportRepo.save(report);

            System.out.println("🔄 Processing started for report: " + report.getReportId());

            // STEP 1: OCR
            String text = ocrService.extract(report.getFilePath());

            // STEP 2: Parsing
            Map<String, Float> values = parsingService.extractParameters(text);

            // STEP 3: Analysis
            analysisService.process(values, report);

            report.setStatus(ReportStatus.COMPLETED);

            System.out.println("✅ Processing completed for report: " + report.getReportId());

        } catch (Exception e) {
            report.setStatus(ReportStatus.FAILED);
            e.printStackTrace();
        }

        reportRepo.save(report);
    }
}