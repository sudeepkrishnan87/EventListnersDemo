package com.mytechexp.eventlistnersdemo.event;

import com.mytechexp.eventlistnersdemo.model.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class UserRegistrationEvent extends ApplicationEvent {
    private final User user;

    public UserRegistrationEvent(Object source, User user)
    {
        super(source);
        this.user=user;
    }
    public User getUSer()
    {
        return user;
    }
}
