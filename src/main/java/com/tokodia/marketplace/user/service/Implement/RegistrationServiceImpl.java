package com.tokodia.marketplace.user.service.Implement;

import com.tokodia.marketplace.user.domain.RegistrationRequest;
import com.tokodia.marketplace.user.entity.User;
import com.tokodia.marketplace.user.repository.UserRepository;
import com.tokodia.marketplace.user.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    @Override
    public User customerRegistration(RegistrationRequest registrationRequest) {
        validateRegistration(registrationRequest);

        return createUser(registrationRequest);
    }

    private User createUser(RegistrationRequest registrationRequest) {
        User user = new User();

        Date date = new Date();
        user.setId(String.valueOf(date.getTime()));
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setPhone((registrationRequest.getPhone()));
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setFullName(registrationRequest.getFirstName() + " " + registrationRequest.getLastName());
        user.setRoleId(3L);
        user.setCreatedBy("SYSTEM");
        user.setUpdatedBy("SYSTEM");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        user.setStatus('I');

        userRepository.save(user);
        return user;
    }

    private void validateRegistration(RegistrationRequest registrationRequest) {
        if (userRepository.findUserByEmailAndPhone(registrationRequest.getEmail(), registrationRequest.getPhone()) != null) {
            throw new RuntimeException("Email or Phone is used");
        }

        if (!registrationRequest.getPassword().equals(registrationRequest.getPassword2())) {
            throw new RuntimeException("Password must be same");
        }
    }
}
