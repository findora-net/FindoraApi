package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "POST")
@Data
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity locationPost;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryPost;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity postOwner;

    @OneToMany(mappedBy = "commentedPost")
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "imagePost")
    private List<ImageEntity> images;

    @OneToMany(mappedBy = "linkPost")
    private List<LinkEntity> links;

    @OneToMany(mappedBy = "reactedPost")
    private List<ReactionPostEntity> reactions;

    @OneToMany(mappedBy = "postTags")
    private List<TagPostEntity> tags;

}
