package com.schizhande.usermanagerservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.schizhande.usermanagerservice.dto.CreateUserRequest;
import lombok.Data;
import lombok.val;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String firstName;

    @Column
    private String surname;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private LocalDate dateOfBirth;

    @Column
    private String jobTitle;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "Africa/Harare", locale = "en_ZW", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date createTimeStamp;

    public static User fromRequest(CreateUserRequest request) {
        val user = new User();
        user.setDateOfBirth(request.getDateOfBirth());
        user.setJobTitle(request.getJobTitle());
        user.setFirstName(request.getFirstName());
        user.setSurname(request.getSurname());
        user.setTitle(request.getTitle());
        return user;
    }

    public void update(CreateUserRequest request) {
        this.setDateOfBirth(request.getDateOfBirth());
        this.setJobTitle(request.getJobTitle());
        this.setFirstName(request.getFirstName());
        this.setSurname(request.getSurname());
        this.setTitle(request.getTitle());
    }
}
