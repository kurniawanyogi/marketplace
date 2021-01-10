package com.tokodia.marketplace.user.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
@Data
public class UserRole {
    @Id
    @Column(name = "ID")
    Long id;

    @Column(name = "ROLE_NAME", length = 50)
    String roleName;
}
