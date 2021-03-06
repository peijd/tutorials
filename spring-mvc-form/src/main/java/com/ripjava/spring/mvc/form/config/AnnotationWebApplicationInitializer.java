package com.ripjava.spring.mvc.form.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AnnotationWebApplicationInitializer  implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();
        root.register(WebConfig.class);


        root.setServletContext(sc);
        root.refresh();

        sc.addListener(new ContextLoaderListener(root));
        DispatcherServlet ds = new DispatcherServlet(new GenericWebApplicationContext());
        ds.setEnableLoggingRequestDetails(true);
        ServletRegistration.Dynamic appServlet =
                sc.addServlet("mvc", ds);
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
