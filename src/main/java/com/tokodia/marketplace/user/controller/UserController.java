package com.tokodia.marketplace.user.controller;

import com.tokodia.marketplace.user.domain.RegistrationRequest;
import com.tokodia.marketplace.user.entity.User;
import com.tokodia.marketplace.user.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    final RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody RegistrationRequest request) {
        User user = registrationService.customerRegistration(request);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
