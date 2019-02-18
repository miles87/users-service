package pl.betse.beontime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path = "/hello")
    public String getUsers() {
        return "HELLO USERS SERVICE";
    }
}
