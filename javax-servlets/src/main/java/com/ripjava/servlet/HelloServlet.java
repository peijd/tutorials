package com.ripjava.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(urlPatterns = {"/helloServlet"})
public class HelloServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init servlet");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service servlet");
        res.getWriter().print("Hello Servlet");
        res.getWriter().flush();
        res.getWriter().close();
    }

    @Override
    public void destroy() {
        System.out.println("destroy servlet");
    }
}

