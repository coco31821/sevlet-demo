package org.example.servletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@WebServlet(
        urlPatterns = { "/c01/03" }
)
public class HttpServletRequestHandlerTest
    extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Http Method
        String method = req.getMethod();
        String requestURI = req.getRequestURI();

        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);

        // Spring Security
        // HTTP Request 인증정보
        String autoType = req.getAuthType();
        System.out.println("autoType = " + autoType);

        // Headers 지금 모든 헤더 정보를 보고 싶음
        // Http Request
        Collections.list(req.getHeaderNames())
                .forEach(
                        headerName -> System.out.println(headerName+ " = " + req.getHeader(headerName))
                );

        // Query Parameter
        // Map
        // domain.com/some/path?key1=val1&key2=val2 -> 알아서 파싱 후 맵으로 반환함.

        // Collection API
        Map<String, String[]> paramMap = req.getParameterMap(); // 단일 파라미터
        paramMap.forEach(
                (key,value)-> System.out.println("key = "+key+ " value = " + Arrays.toString(value))
        );


    }
}
