package com.ripjava.servlet;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloServletTest {
    private Server server;

    @BeforeEach
    public  void startJetty() throws Exception
    {
        server = new Server(8080);
        server.setStopAtShutdown(true);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(HelloServlet.class, "/helloServlet");
        server.setHandler(handler);
        server.start();
    }

    @Test
    public void test_HelloServlet() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8080/helloServlet");
        CloseableHttpResponse response = httpClient.execute(request);


        HttpEntity entity = response.getEntity();

        assertEquals("Hello Servlet", EntityUtils.toString(entity));
    }

    @AfterEach
    public void tearDown() throws Exception {
        server.stop();
    }
}
