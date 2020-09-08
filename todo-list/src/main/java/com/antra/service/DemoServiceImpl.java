package com.antra.service;

import org.springframework.stereotype.Service;

@Service //another stereotype annotation like component and controller
public class DemoServiceImpl implements DemoService{
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application.";
    }
}
