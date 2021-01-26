package com.tokodia.marketplace.email.repository;

import com.tokodia.marketplace.email.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    ConfirmationToken findConfirmationTokenByToken(String token);
}
