package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "RESPONSE")
@Data
public class ResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity commentResponse;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity responseOwner;

    @Column(name="text")
    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "rate")
    private Integer rate;

    @OneToMany(mappedBy = "reactResponse")
    private List<ReactionResponseEntity> reactions;

}
