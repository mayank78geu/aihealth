package com.mednext.aihealth.repository;

import com.mednext.aihealth.entity.MedicalParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParameterRepository extends JpaRepository<MedicalParameter, Integer> {
    Optional<MedicalParameter> findByParamName(String paramName);
}