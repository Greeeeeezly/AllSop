package com.example.excursionbookingapi.controllers;

import com.example.excursionbookingapi.dto.BookingDto;
import com.example.excursionbookingapi.dto.BookingRequest;
import com.example.excursionbookingapi.exceptions.BookingNotFoundException;
import com.example.excursionbookingapi.exceptions.InvalidArgumentException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "bookings")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})

public interface BookingController {
    @GetMapping(value = "/api/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение информации о всех бронированиях")
    public CollectionModel<EntityModel<BookingDto>> getAllBookings();

    @GetMapping(value = "/api/bookings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение информации о бронировании")
    public EntityModel<BookingDto> getBookingById(@PathVariable Long id) throws BookingNotFoundException;

    @PostMapping(value = "/api/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Создание бронирования")
    public ResponseEntity<String> createBooking(@Valid @RequestBody BookingRequest booking) throws InvalidArgumentException;

    @DeleteMapping(value = "/api/bookings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Удаление бронирования")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) throws BookingNotFoundException;
}
