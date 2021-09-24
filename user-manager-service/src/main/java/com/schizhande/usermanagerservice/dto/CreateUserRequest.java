package com.schizhande.usermanagerservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class CreateUserRequest {

    @JsonIgnore
    private Long id;

    @NotBlank(message = "Title should be provided")
    private String title;

    @NotBlank(message = "FirstName should be provided")
    private String firstName;

    @NotBlank(message = "Surname should be provided")
    private String surname;

    @NotNull(message = "DOB should be provided")
    @Past(message = "Invalid date of birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", locale = "en_ZW", timezone = "Africa/Harare")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Job title should be provided")
    private String jobTitle;

}
