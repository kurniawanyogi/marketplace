package com.tokodia.marketplace.user.service;

import com.tokodia.marketplace.user.domain.RegistrationRequest;
import com.tokodia.marketplace.user.entity.User;

public interface RegistrationService {
    User customerRegistration(RegistrationRequest registrationRequest);
}
