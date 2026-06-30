package es.api.findora.infrastructure.persistence.entity;

import es.api.findora.infrastructure.persistence.entity.ReactionResponse;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "RESPONSE")
@Data
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment commentResponse;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User responseOwner;

    @Column(name="text")
    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "rate")
    private Integer rate;

    @OneToMany(mappedBy = "reactResponse")
    private List<ReactionResponse> reactions;

}
