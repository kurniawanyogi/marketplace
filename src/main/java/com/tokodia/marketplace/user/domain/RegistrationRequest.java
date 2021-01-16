package com.tokodia.marketplace.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegistrationRequest {

    @NotEmpty
    @Size(max = 100)
    private String email;

    @NotEmpty
    @Size(max = 50)
    private String password;

    @NotEmpty
    @Size(max = 50)
    private String password2;

    @NotEmpty
    @Size(max = 20, min = 9)
    private String phone;

    @NotEmpty
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;
}
