package com.mytechexp.eventlistnersdemo.service;

import com.mytechexp.eventlistnersdemo.event.UserRegistrationEvent;
import com.mytechexp.eventlistnersdemo.model.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ApplicationEventPublisher eventPublisher;

    public UserService(ApplicationEventPublisher eventPublisher)
    {
        this.eventPublisher=eventPublisher;
    }
    public void registrUser(User user)
    {
        eventPublisher.publishEvent(new UserRegistrationEvent(this,user));
    }
}
