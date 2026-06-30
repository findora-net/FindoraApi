package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "TAG_POST")
@IdClass(TagPostId.class)
public class TagPostEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postTags;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;
}
