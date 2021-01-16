package com.tokodia.marketplace.user.service.Implement;

import com.tokodia.marketplace.general.exception.RegistrationException;
import com.tokodia.marketplace.user.domain.RegistrationRequest;
import com.tokodia.marketplace.user.entity.User;
import com.tokodia.marketplace.user.repository.UserRepository;
import com.tokodia.marketplace.user.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User customerRegistration(RegistrationRequest registrationRequest) {
        validateRegistration(registrationRequest);

        return createUserCustomer(registrationRequest);
    }

    private User createUserCustomer(RegistrationRequest registrationRequest) {
        User user = new User();

        Date date = new Date();
        user.setId(String.valueOf(date.getTime()));
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setPhone((registrationRequest.getPhone()));
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());

        if (registrationRequest.getLastName() == null || registrationRequest.getLastName().isEmpty()) {
            user.setFullName(registrationRequest.getFirstName());
        } else {
            user.setFullName(registrationRequest.getFirstName() + " " + registrationRequest.getLastName());
        }

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
            throw new RegistrationException("Email or Phone has been used");
        }

        if (!registrationRequest.getPassword().equals(registrationRequest.getPassword2())) {
            throw new RegistrationException("Password must be same");
        }

        String regexEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern patternEmail = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
        Matcher matcherEmail = patternEmail.matcher(registrationRequest.getEmail());
        if (!matcherEmail.matches()) {
            throw new RegistrationException("email is not valid");
        }

        String regexPhone = "^\\+([0-9]{8,19})";
        Pattern patternPhone = Pattern.compile(regexPhone);
        Matcher matcherPhone = patternPhone.matcher(registrationRequest.getPhone());

        if (!matcherPhone.matches()) {
            throw new RegistrationException("phone number is not valid");
        }

        String regexPassword = "^(?=.*[0-9])((?=.*[a-z])||(?=.*[A-Z])||(?=.*[@#$%^&+=]))(?=\\S+$).{8,}$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(registrationRequest.getPassword());

        if (!matcherPassword.matches()) {
            throw new RegistrationException("password is not valid, password must be 8 length with number and alphabeth");
        }
    }
}
