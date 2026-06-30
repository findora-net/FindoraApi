package es.api.findora.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "USER")
public class UserEntity {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "image")
    private String image;

    @Column(name = "birthdate")
    private LocalDateTime birthdate;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Enum<RoleUser> role;

    @Column(name = "point")
    private Integer point;

    @Column(name = "status")
    private Enum<StatusUser> status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "commentOwner")
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "reportOwner")
    private List<ReportEntity> reports;

    @OneToMany(mappedBy = "responseOwner")
    private List<ResponseEntity> responses;

    @OneToMany(mappedBy = "creator")
    private List<LocationEntity> locationsCreated;

    @OneToMany(mappedBy = "postOwner")
    private List<PostEntity> postsCreatedByThisUser;

    @OneToMany(mappedBy = "reactCommentUser")
    private List<ReactionCommentEntity> reactionsComments;

    @OneToMany(mappedBy = "reactPostUser")
    private List<ReactionPostEntity> reactionsPosts;

    @OneToMany(mappedBy = "reactResponseUser")
    private List<ReactionResponseEntity> reactionsResponses;

    @OneToMany(mappedBy = "originUser")
    private List<SocialRelationEntity> socialRelationsOriginUser;

    @OneToMany(mappedBy = "targetUser")
    private List<SocialRelationEntity> socialRelationsTargetUser;


}
