package com.tokodia.marketplace.user.entity;

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

    @Column(name = "PASSWORD", length = 255)
    private String password;

    @Column(name = "FULLNAME", length = 101)
    private String fullName;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "STATUS", length = 1)
    private Character status;

}