package com.tokodia.marketplace.user.controller;

import com.tokodia.marketplace.general.response.BaseResponse;
import com.tokodia.marketplace.user.domain.RegistrationRequest;
import com.tokodia.marketplace.user.entity.User;
import com.tokodia.marketplace.user.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    final RegistrationService registrationService;

    //TODO Handler @Valid


    @PostMapping("/registration")
    public ResponseEntity registration(@Validated @RequestBody RegistrationRequest request) {
        User user = registrationService.customerRegistration(request);
        return new ResponseEntity(new BaseResponse(HttpStatus.OK.toString(), "User Saved", user), HttpStatus.OK);
    }
}
