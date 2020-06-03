package com.ripjava.xmlbase;

public class IndexApp {
    private IService service;

    public IndexApp(IService service) {
        this.service = service;
    }

    public IndexApp() {
    }

    public IService getService() {
        return service;
    }

    public void setService(IService service) {
        this.service = service;
    }

}
