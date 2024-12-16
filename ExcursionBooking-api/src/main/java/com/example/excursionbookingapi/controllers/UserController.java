package com.example.excursionbookingapi.controllers;

import com.example.excursionbookingapi.dto.UserDto;
import com.example.excursionbookingapi.dto.UserRequest;
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


@Tag(name = "users")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface UserController {
    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение информации о всех пользователях")
    public CollectionModel<EntityModel<UserDto>> getAllCustomers();

    @GetMapping(value = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение информации о пользователе")
    public EntityModel<UserDto> getCustomerById(@PathVariable Long id) throws UserNotFoundException;

    @PostMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Создание пользователя")
    public EntityModel<UserDto> createCustomer(@Valid @RequestBody UserRequest customer) throws InvalidArgumentException;

    @PostMapping(value = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Обновление данных о пользователе")
    public EntityModel<UserDto> updateCustomer(@PathVariable Long id, @Valid @RequestBody UserDto updatedCustomer) throws UserNotFoundException, InvalidArgumentException;

    @DeleteMapping(value = "api/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Удаление пользователя")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) throws UserNotFoundException;
}
