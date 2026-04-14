package com.mednext.aihealth.repository;

import com.mednext.aihealth.entity.OCRRawText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OCRRepository extends JpaRepository<OCRRawText, Integer> {
}