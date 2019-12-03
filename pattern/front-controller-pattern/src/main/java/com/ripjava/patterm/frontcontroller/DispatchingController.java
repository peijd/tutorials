package com.ripjava.patterm.frontcontroller;

import com.ripjava.patterm.frontcontroller.commands.AbstractCommand;
import com.ripjava.patterm.frontcontroller.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatchingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        AbstractCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
    }

    private AbstractCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(String.format(
                    "com.ripjava.patterm.frontcontroller.commands."
                            + "%sCommand",
                    request.getParameter("command")));
            return (AbstractCommand) type
                    .asSubclass(AbstractCommand.class)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}
