package com.tokodia.marketplace.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Getter
@Setter
public class User {
    @Id
    @Column(name = "ID", length = 20)
    private String id;

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @JsonIgnore
    @Column(name = "PASSWORD", length = 255)
    private String password;

    @Column(name = "FULLNAME", length = 101)
    private String fullName;

    @JsonIgnore
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @JsonIgnore
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @JsonIgnore
    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @JsonIgnore
    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    @JsonIgnore
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @JsonIgnore
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "STATUS", length = 1)
    private Character status;

}