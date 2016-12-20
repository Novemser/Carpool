package com.carpool.website.controller.exception;

import com.carpool.exception.DuplicateLoginException;
import com.carpool.exception.PermissionDeniedException;
import com.carpool.exception.ResourceNotFoundException;
import com.carpool.exception.UserNullException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller.exception
 * Author:  Novemser
 * 2016/11/30
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(UserNullException.class)
    public ModelAndView handleNullUserException(UserNullException e) {
        ModelAndView model = new ModelAndView();
        model.addObject("errCode", e.getErrCode());
        model.addObject("errMsg", e.getErrMsg());
        return model;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        System.out.println("Not found!!");
        return "pages/404";
    }

    @ExceptionHandler(DuplicateLoginException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleDuplicateLoginException(){
        return "pages/404";
    }

    @ExceptionHandler(PermissionDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handlePermissionDeniedException(){
        return "pages/404";
    }

}
