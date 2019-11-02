package com.ripjava.spring.properties.json;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

@Component
@PropertySource(value = "classpath:configprops.json", factory = JsonPropertySourceFactory.class)
@ConfigurationProperties
public class JsonProperties {

    private int port;

    private boolean resend;

    private String host;


    private List<String> topics;


    private LinkedHashMap<String, ?> sender;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isResend() {
        return resend;
    }

    public void setResend(boolean resend) {
        this.resend = resend;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public LinkedHashMap<String, ?> getSender() {
        return sender;
    }

    public void setSender(LinkedHashMap<String, ?> sender) {
        this.sender = sender;
    }
}
