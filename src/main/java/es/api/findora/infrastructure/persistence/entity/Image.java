package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "IMAGE")
@Data
@IdClass(ImageId.class)
public class Image {
    @Id
    private Integer num;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post imagePost;

    @Column(name = "image")
    private String image;

}
