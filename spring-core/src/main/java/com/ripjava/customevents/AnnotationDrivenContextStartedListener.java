package com.ripjava.customevents;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationDrivenContextStartedListener {
    @EventListener(CustomSpringEvent.class)
    public void handleContextStart(CustomSpringEvent event) {
        System.out.println("ripjava.com: @EventListener收到消息-" + event.getMessage());
    }
}
