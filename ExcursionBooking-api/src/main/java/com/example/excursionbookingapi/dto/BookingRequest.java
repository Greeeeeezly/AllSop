package com.example.excursionbookingapi.dto;

import jakarta.validation.constraints.NotNull;

public class BookingRequest {

    @NotNull(message = "Id тура не должно быть null")
    private Long tourId;
    @NotNull(message = "Id пользователя не должно быть null")
    private Long userId;

    public BookingRequest() {}

    public BookingRequest(Long tourId, Long userId) {
        this.tourId = tourId;
        this.userId = userId;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
