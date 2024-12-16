package com.example.excursionbookingapi.dto;


public class BookingDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private UserDto user;

    private TourDto tour;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public TourDto getTour() {
        return tour;
    }

    public void setTour(TourDto tour) {
        this.tour = tour;
    }
}
