package com.mednext.aihealth.service.impl;

import com.mednext.aihealth.entity.Report;
import com.mednext.aihealth.entity.ReportStatus;
import com.mednext.aihealth.repository.ReportRepository;
import com.mednext.aihealth.service.FileStorageService;
import com.mednext.aihealth.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Map;
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepo;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public Object uploadReport(MultipartFile file, Integer userId)
    {
        String path = fileStorageService.save(file);
        Report report = new Report();
        report.setFilePath(path);
        report.setUploadTime(new Timestamp(System.currentTimeMillis()));
        report.setStatus(ReportStatus.UPLOADED);

        reportRepo.save(report);

        return Map.of(
                "report_id",report.getReportId(),
                "message", "Report uploaded Successfully"
        );
    }
}
