package com.example.evenet;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhougaojun
 * @since 2022/3/4
 */
public class UserRegisterEvent extends ApplicationEvent {

    private String username;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
