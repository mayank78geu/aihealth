package com.mednext.aihealth.repository;

import com.mednext.aihealth.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}