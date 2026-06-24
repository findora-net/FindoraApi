package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "REPORT_COMMENT")
public class ReportComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at")
    private Integer createdAt;

    @Column(name = "comment_reported_id")
    private Long commentReportedId;

}
