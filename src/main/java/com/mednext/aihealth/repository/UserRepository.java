package com.mednext.aihealth.repository;

import com.mednext.aihealth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}