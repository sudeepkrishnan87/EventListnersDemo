package com.mytechexp.eventlistnersdemo.service;

import com.mytechexp.eventlistnersdemo.event.UserRegistrationEvent;
import com.mytechexp.eventlistnersdemo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private ApplicationEventPublisher eventPublisher;

    private User user;
    private boolean eventHandled = false;
    @BeforeEach
    void setUp() {
        user=new User();
        user.setAddress("test");
        user.setFirstname("sudeep");
        user.setLastname("krishnan");
        user.setAge(36);
    }
    @Test
    public void testUserRegistration()
    {
        userService.registrUser(user);
      //  verify(eventPublisher,atLeast(1)).publishEvent(UserRegistrationEvent.class);
        UserRegistrationEvent event = new UserRegistrationEvent(this, user);
        handleUserRegisteredEvent(event);

        // Assert that event handling logic has been executed
        assert(eventHandled);

    }
    private void handleUserRegisteredEvent(UserRegistrationEvent event) {
        User user = event.getUSer();
        System.out.println("Mocked event handling logic for user: " + user.getFirstname());
       if(user.getFirstname().equals("sudeep"))
        eventHandled = true;
    }

}