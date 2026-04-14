package com.mednext.aihealth.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String filePath;

    private Timestamp uploadTime;


    @Enumerated(EnumType.STRING)
    private ReportStatus status;
}