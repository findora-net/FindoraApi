package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "TAG")
@Data
public class TagEntity {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private Integer value;

    @OneToMany(mappedBy = "tag")
    private List<TagPostEntity> posts;
}
