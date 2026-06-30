package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "COMMENT")
@Data
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity commentedPost;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity commentOwner;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "rate")
    private Integer rate;

    @OneToMany(mappedBy = "reactedComment")
    private List<ReactionCommentEntity> reactions;

    @OneToMany(mappedBy = "commentResponse")
    private List<ResponseEntity> responses;


}
