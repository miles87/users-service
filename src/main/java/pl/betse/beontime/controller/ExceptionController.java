package pl.betse.beontime.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.betse.beontime.myException.UserNotFoundException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String myExceptionHandler(UserNotFoundException e){
        return e.getMessage();
    }
}
