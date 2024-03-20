package com.example.interceptormiddleware2.interceptor;

import com.example.interceptormiddleware2.entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    ));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String headers = request.getHeader("month");

        if (headers == null || headers.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        Month month = find(Integer.valueOf(headers));

        request.setAttribute("month", Objects.requireNonNullElseGet(month, () -> new Month(null, "nope", "nope", "nope")));
        response.setStatus(HttpStatus.OK.value());
        return true;
    }

    private Month find(Integer integer) {
        for (Month month : monthList) {

            if (month.getMonthNumber().equals(integer)) {
                return month;
            }
        }
        return null;
    }

}
