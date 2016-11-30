package com.carpool.website.controller.exception;

import com.carpool.exception.UserNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
}
