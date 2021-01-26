package com.tokodia.marketplace.email.entity;

import com.tokodia.marketplace.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CONFIRMATION_TOKEN")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "EXPIRED_DATE")
    private LocalDateTime expiredDate;

    @Column(name = "CONFIRMED_DATE")
    private LocalDateTime confirmedDate;

    public ConfirmationToken(User user, String token, LocalDateTime createdDate, LocalDateTime expiredDate) {
        this.user = user;
        this.token = token;
        this.createdDate = createdDate;
        this.expiredDate = expiredDate;
    }
}
