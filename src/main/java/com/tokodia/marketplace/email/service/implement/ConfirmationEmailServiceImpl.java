package com.tokodia.marketplace.email.service.implement;

import com.tokodia.marketplace.email.entity.ConfirmationToken;
import com.tokodia.marketplace.email.repository.ConfirmationTokenRepository;
import com.tokodia.marketplace.email.service.ConfirmationEmailService;
import com.tokodia.marketplace.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmationEmailServiceImpl implements ConfirmationEmailService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public void sendConfirmationToken(User user) {

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                user, token, LocalDateTime.now(), LocalDateTime.now().plusDays(1L)
        );

        confirmationTokenRepository.save(confirmationToken);

        // TODO SEND EMAIL WITH LINK ACTIVATION
    }
}
