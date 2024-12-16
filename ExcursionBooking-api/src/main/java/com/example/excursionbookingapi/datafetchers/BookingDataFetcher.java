package com.example.excursionbookingapi.datafetchers;

import com.example.excursionbookingapi.dto.BookingDto;
import com.example.excursionbookingapi.dto.TourDto;
import com.example.excursionbookingapi.dto.UserDto;
import com.example.excursionbookingapi.exceptions.BookingNotFoundException;
import com.example.excursionbookingapi.exceptions.InvalidArgumentException;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Description;

import java.util.List;
@Tag(name = "booking_dgs")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface BookingDataFetcher{

    @Operation(summary = "Получить список всех бронирований")
    public List<BookingDto> bookings();

    @Operation(summary = "Добавить новое бронирование")
    public String addBooking(@InputArgument @Valid SubmittedBooking booking) throws BookingNotFoundException, InvalidArgumentException;

    @Operation(summary = "Удалить бронирование по ID")
    public void deleteBooking(@InputArgument Long id) throws BookingNotFoundException;

    record SubmittedBooking(
            @Description("Данные пользователя для бронирования")
            UserDto user,

            @Description("Данные тура для бронирования")
            TourDto tour) {}
}
