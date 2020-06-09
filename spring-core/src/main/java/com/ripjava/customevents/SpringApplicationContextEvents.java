package com.ripjava.customevents;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContextEvents {

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent ctxRefreshedEvt) {
        System.out.println("ripjava.com: Context Refreshed Event received.");
    }
}
