package com.mednext.aihealth.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ocr_raw_text")
public class OCRRawText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ocrId;

    @OneToOne
    @JoinColumn(name = "report_id")
    private Report report;

    @Lob
    private String extractedText;
}