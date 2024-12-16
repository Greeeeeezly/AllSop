package com.example.excursionbookingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TourRequest {
    @NotBlank(message = "Имя тура обязательно")
    private String name;
    @NotNull(message = "Количество мест не может быть null")
    private int availableSeats;

    public TourRequest(String name, int availableSeats) {
        this.name = name;
        this.availableSeats = availableSeats;
    }
}
