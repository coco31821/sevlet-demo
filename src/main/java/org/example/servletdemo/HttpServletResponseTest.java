package org.example.servletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/c01/05"}
)
public class HttpServletResponseTest
    extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setStatus(HttpServletResponse.SC_OK);    // 응답번호 직접 줌

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // header
        // key=value
        // 헤더 너무 크면 안된다.
        // 이유 ) 통신상 안되고, 서버에서 안받아준다. 보안이슈도 있음.
        resp.setHeader("X-CUSTOM-HEADER","CUSTOM_VALUE");
        resp.setHeader("X-SUPER-COMPLEX-KEY","SUPER_COMPLEX_VALUE");

        Cookie cookie = new Cookie("custom-cookie", "custom-value");

        cookie.setMaxAge(3600);
        cookie.setPath("/");

        resp.addCookie(cookie);

        // Response Body
        PrintWriter writer = resp.getWriter();

        // 이스케이핑
        writer.write("{ \"message\" : \"Hello World!\" }");
        writer.flush();





    }
}
