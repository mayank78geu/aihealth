package com.mednext.aihealth.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "report_parameters")
public class ReportParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rpId;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    @ManyToOne
    @JoinColumn(name = "param_id")
    private MedicalParameter parameter;

    private Float value;
}