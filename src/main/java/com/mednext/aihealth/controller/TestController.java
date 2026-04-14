package com.mednext.aihealth.controller;

import com.mednext.aihealth.entity.Report;
import com.mednext.aihealth.entity.ReportStatus;
import com.mednext.aihealth.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/insert")
    public String insertTest() {
        Report report = new Report();
        report.setFilePath("test/path/sample/pdf");
        report.setUploadTime(new Timestamp(System.currentTimeMillis()));
        report.setStatus(ReportStatus.UPLOADED);

        reportRepository.save(report);

        return "Inserted Successfully";
    }

}
