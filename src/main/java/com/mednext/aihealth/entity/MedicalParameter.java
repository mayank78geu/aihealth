package com.mednext.aihealth.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_parameters_master")
public class MedicalParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paramId;

    @Column(unique = true)
    private String paramName;

    private String unit;
}