package com.mednext.aihealth.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reference_ranges")
public class ReferenceRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rangeId;

    @OneToOne
    @JoinColumn(name = "param_id")
    private MedicalParameter parameter;

    private Float minValue;
    private Float maxValue;
}