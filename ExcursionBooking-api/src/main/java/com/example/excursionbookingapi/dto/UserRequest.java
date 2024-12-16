package com.example.excursionbookingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRequest {
    @NotBlank(message = "Имя обязательно")
    private String name;
    @NotBlank(message = "Email обязателен")
    private String email;

    @NotNull(message = "Приоритет обязателен true/false")
    private boolean priority;

    @NotNull(message = "Активен или нет, если обычный, то false")
    private boolean isActive;


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserRequest(String name, String email, boolean priority, boolean isActive) {
        this.name = name;
        this.email = email;
        this.priority = priority;
        this.isActive = isActive;
    }

    public UserRequest() {}

    public UserRequest(String name, String email, boolean priority) {
        this.name = name;
        this.email = email;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

}
