package com.mednext.aihealth.service;

import org.springframework.web.multipart.MultipartFile;

public interface ReportService {
    Object uploadReport(MultipartFile file, Integer userId);
}
