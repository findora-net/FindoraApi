package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "TAG_POST")
@IdClass(TagPostId.class)
public class TagPost {
    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postTags;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
