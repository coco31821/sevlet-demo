package org.example.servletdemo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/jsp/01")
public class HelloJSP extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");



        //jsp에 위치를 다 집어넣고 파일 위치를 찝어줘야함.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/HelloWorld.jsp");
        dispatcher.forward(req,resp);


    }
}
