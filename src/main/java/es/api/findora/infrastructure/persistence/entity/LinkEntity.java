package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LINK")
@IdClass(LinkId.class)
@Data
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity linkPost;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

}
