package com.example.jpademo.common;

import com.example.jpademo.common.exception.ExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public final String internalExceptionHandler(Exception e, Model model, WebRequest request) {
        log.info("internal error :" + e.toString());

//        ExceptionResponse exceptionResponse = new ExceptionResponse().builder()
//                .timestamp(new Date())
//                .message(e.getMessage())
//                .details(request.getDescription(false))
//                .build();
//        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

//        model.addAttribute("status", status.toString());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        model.addAttribute("msg", e.toString());
        model.addAttribute("timestamp", new Date());
        return "/error/common_error";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExistsException.class)
    public String userExceptionHandler(Exception e, Model model, WebRequest request) {
        log.info("user error :" + e.toString());
//        log.info("details :" + request.getDescription(false));

        model.addAttribute("status", HttpStatus.BAD_REQUEST);
        model.addAttribute("msg", e.toString());
        model.addAttribute("timestamp", new Date());
        return "/error/common_user_error";
    }
}
