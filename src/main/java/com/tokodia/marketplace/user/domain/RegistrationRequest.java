package com.tokodia.marketplace.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegistrationRequest {
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String password2;

    @NotNull
    private String phone;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
