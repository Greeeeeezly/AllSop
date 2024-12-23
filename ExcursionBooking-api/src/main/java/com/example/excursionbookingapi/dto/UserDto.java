package com.example.excursionbookingapi.dto;

public class UserDto{
    private Long id;
    private String name;
    private String email;
    private boolean priority;
    private boolean isActive;

    public UserDto(Long id, String name, String email, boolean priority, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.priority = priority;
        this.isActive = isActive;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
