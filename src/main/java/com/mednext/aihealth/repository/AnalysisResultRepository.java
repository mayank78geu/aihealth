package com.mednext.aihealth.repository;

import com.mednext.aihealth.entity.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisResultRepository extends JpaRepository<AnalysisResult, Integer> {
}