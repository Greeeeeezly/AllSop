package com.example.excursionbookingapi.datafetchers;

import com.example.excursionbookingapi.dto.TourDto;
import com.example.excursionbookingapi.exceptions.InvalidArgumentException;
import com.example.excursionbookingapi.exceptions.TourNotFoundException;
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
@Tag(name = "tours_dgs")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface TourDataFetcher {

    @Operation(summary = "Получить список всех туров")
    public List<TourDto> tours();

    @Operation(summary = "Добавить новый тур")
    public TourDto addTour(@InputArgument @Valid SubmittedTour tour) throws InvalidArgumentException;

    @Operation(summary = "Обновить данные о туре")
    public TourDto updateTour(@InputArgument Long id, @InputArgument @Valid SubmittedTour tour) throws InvalidArgumentException, TourNotFoundException;

    @Operation(summary = "Удалить тур по ID")
    public void deleteTour(@InputArgument Long id) throws TourNotFoundException;

    record SubmittedTour(
            @Description("Название тура")
            String name,

            @Description("Количество доступных мест")
            Integer availableSeats
    ) {}
}
