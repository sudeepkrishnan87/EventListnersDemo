package com.mytechexp.eventlistnersdemo.event;

import com.mytechexp.eventlistnersdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserRegisteredEventListener {
   @EventListener
    public void handleUserRegisteredEvent(UserRegistrationEvent userEvent)
    {
        User user = userEvent.getUSer();
        log.info("Firstname is {}  and age is {}",user.getFirstname(),user.getAge());
    }
}
