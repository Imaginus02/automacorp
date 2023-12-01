package com.emse.spring.automacorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyUserService implements UserService{

    private ConsoleGreetingService consoleGreetingService;

    @Autowired
    public DummyUserService(ConsoleGreetingService consoleGreetingService) {
        this.consoleGreetingService = consoleGreetingService;
    }

    public ConsoleGreetingService getConsoleGreetingService() {
        return consoleGreetingService;
    }

    public void greetAll(List<String> name) {
        for (String s : name) {
            consoleGreetingService.greet(s);
        }
    }
}
