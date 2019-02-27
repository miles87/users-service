package pl.betse.beontime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.betse.beontime.bo.UserDTO;
import pl.betse.beontime.model.validation.LoginUserValidation;
import pl.betse.beontime.myException.UserBadCredentialException;
import pl.betse.beontime.service.UsersService;
import pl.betse.beontime.utils.CustomResponseMessage;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    UsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping
    public @ResponseBody
    CustomResponseMessage
    checkUserCredentials(@RequestBody @Validated(LoginUserValidation.class) UserDTO incomingUserCredentials) {

        if (!usersService.existsByEmailLogin(incomingUserCredentials.getEmailLogin())) {
            throw new UserBadCredentialException();
        }

        if (!passwordEncoder.matches(incomingUserCredentials.getPassword(), usersService.getUserByEmail(incomingUserCredentials.getEmailLogin()).getPassword())) {
            throw new UserBadCredentialException();
        }


        return new CustomResponseMessage(HttpStatus.OK, "User credentials accepted. Logged.");
    }


}
