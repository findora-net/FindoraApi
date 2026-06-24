package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LINK")
@Data
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

}
