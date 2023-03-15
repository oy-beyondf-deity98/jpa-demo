package com.example.jpademo.common;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Slf4j
@Controller
public class ExceptionHandlingController implements ErrorController {
    private final String ERROR_ETC_PAGE_PATH = "/error/etc_error";
    private final String ERROR_TIME_OUT_PATH = "/error/timeout_error";

    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request, Model model) {
// 에러 코드를 획득한다.
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // 에러 코드에 대한 상태 정보
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));

        if (status != null) {
            // HttpStatus와 비교해 페이지 분기를 나누기 위한 변수
            int statusCode = Integer.valueOf(status.toString());

            // 로그로 상태값을 기록 및 출력
            log.info("httpStatus : " + statusCode);

            model.addAttribute("status", status.toString());
            model.addAttribute("msg", httpStatus.getReasonPhrase());
            model.addAttribute("timestamp", new Date());

            if(statusCode == HttpStatus.BAD_REQUEST.value() ||
                    statusCode == HttpStatus.NOT_FOUND.value() ||
                    statusCode == HttpStatus.BAD_GATEWAY.value() ||
                    statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()
            ){
                return "/error/" + statusCode;
            }

            if(statusCode == HttpStatus.REQUEST_TIMEOUT.value() ||
                    statusCode == HttpStatus.GATEWAY_TIMEOUT.value()
            ){
                return ERROR_TIME_OUT_PATH;
            }
        }

        // 정의한 에러 외 모든 에러는 error/common_error 페이지로 보낸다.
        return ERROR_ETC_PAGE_PATH;
    }

    public String getErrorPath() {
        return "/error";
    }

}
