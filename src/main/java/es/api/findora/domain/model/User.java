package es.api.findora.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {

    private final int POINT_LIMIT = 10;

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String image;
    private LocalDate birthdate;
    private String email;
    private String password;
    private RoleUser role;
    private int point;
    private StatusUser status;
    private LocalDateTime createdAt;

    public int getLevel(){
        return (int) Math.floor(point/POINT_LIMIT);
    }
}
