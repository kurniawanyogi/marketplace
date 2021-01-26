package com.tokodia.marketplace.email.service;

import com.tokodia.marketplace.user.entity.User;

public interface ConfirmationEmailService {
    void sendConfirmationToken(User user);
}
