package com.mednext.aihealth.repository;

import com.mednext.aihealth.entity.ReferenceRange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRangeRepository extends JpaRepository<ReferenceRange, Integer> {
}