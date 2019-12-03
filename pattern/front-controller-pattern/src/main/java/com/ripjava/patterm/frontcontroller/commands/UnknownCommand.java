package com.ripjava.patterm.frontcontroller.commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends AbstractCommand{
    @Override
    public void process() throws ServletException, IOException {
        forward("unknown");
    }
}
