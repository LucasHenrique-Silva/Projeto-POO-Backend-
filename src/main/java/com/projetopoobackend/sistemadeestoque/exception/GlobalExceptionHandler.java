package com.projetopoobackend.sistemadeestoque.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFoundError(NoHandlerFoundException ex) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/index");
        return model;
    }
}
