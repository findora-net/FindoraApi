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
public class User {

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
    private List<Comment> comments;

    @OneToMany(mappedBy = "reportOwner")
    private List<Report> reports;

    @OneToMany(mappedBy = "responseOwner")
    private List<Response> responses;

    @OneToMany(mappedBy = "creator")
    private List<Location> locationsCreated;

    @OneToMany(mappedBy = "postOwner")
    private List<Post> postsCreatedByThisUser;

    @OneToMany(mappedBy = "reactCommentUser")
    private List<ReactionComment> reactionsComments;

    @OneToMany(mappedBy = "reactPostUser")
    private List<ReactionPost> reactionsPosts;

    @OneToMany(mappedBy = "reactResponseUser")
    private List<ReactionResponse> reactionsResponses;

    @OneToMany(mappedBy = "originUser")
    private List<SocialRelation> socialRelationsOriginUser;

    @OneToMany(mappedBy = "targetUser")
    private List<SocialRelation> socialRelationsTargetUser;


}
