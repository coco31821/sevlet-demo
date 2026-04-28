package org.example.servletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "WiseSayingServlet",
        urlPatterns = {"/wise"}
)
public class WiseSayingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Http Response Content-Type
        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().println("요즘 생각하는 말:");
        resp.getWriter().println("내가 이적이라면 어케했을까?");


    }
}
