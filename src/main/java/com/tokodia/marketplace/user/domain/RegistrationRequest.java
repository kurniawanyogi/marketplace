package com.tokodia.marketplace.user.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tokodia.marketplace.general.validator.FieldMatcher;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldMatcher(firstField = "password", secondField = "confirmPassword", message = "wrong confirm password")
public class RegistrationRequest {

    @NotEmpty(message = "email cannot empty")
    @Email
    @Size(max = 100)
    private String email;

    @NotEmpty
    @Size(max = 30)
//    @Password
    private String password;

    @NotEmpty
    @Size(max = 30)
//    @Password
    private String confirmPassword;

    @NotEmpty
    @Size(max = 20, min = 9)
    private String phone;

    @NotEmpty
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;
}
