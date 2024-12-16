package com.example.excursionbookingapi.controllers;

import com.example.excursionbookingapi.dto.TourDto;
import com.example.excursionbookingapi.dto.TourRequest;
import com.example.excursionbookingapi.exceptions.InvalidArgumentException;
import com.example.excursionbookingapi.exceptions.UserNotFoundException;
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

@Tag(name = "tours")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface TourController {
    @GetMapping(value = "/api/tours", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение информации о всех турах")
    public CollectionModel<EntityModel<TourDto>> getAllTours();

    @GetMapping(value = "/api/tours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение информации о туре")
    public EntityModel<TourDto> getTourById(@PathVariable Long id) throws UserNotFoundException;

    @PostMapping(value = "/api/tours", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Создание тура")
    public EntityModel<TourDto> createTour(@Valid @RequestBody TourRequest tour) throws InvalidArgumentException;

    @DeleteMapping(value = "/api/tours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Удаление тура")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) throws UserNotFoundException;
}
