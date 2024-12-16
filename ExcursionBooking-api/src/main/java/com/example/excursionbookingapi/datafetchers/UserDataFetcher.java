package com.example.excursionbookingapi.datafetchers;

import com.example.excursionbookingapi.dto.UserDto;
import com.example.excursionbookingapi.exceptions.InvalidArgumentException;
import com.example.excursionbookingapi.exceptions.UserNotFoundException;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Description;

import java.util.List;

@Tag(name = "Users")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface UserDataFetcher {
    @Operation(summary = "Получить список всех пользователей с фильтром по имени")
    public List<UserDto> users(@InputArgument String nameFilter);

    @Operation(summary = "Добавить нового пользователя")
    public UserDto addUser(@InputArgument(name = "user") SubmittedUser userInput) throws InvalidArgumentException;

    @Operation(summary = "Обновить данные пользователя")
    public UserDto updateUser(@InputArgument Long id, @InputArgument(name = "user") SubmittedUser userInput) throws UserNotFoundException, InvalidArgumentException;

    @Operation(summary = "Удалить пользователя по ID")
    public void deleteUser(@InputArgument Long id) throws UserNotFoundException;

    public record SubmittedUser(
            @Description("Имя пользователя")
            String name,

            @Description("Электронная почта пользователя")
            String email,

            @Description("Приоритетный статус пользователя")
            Boolean priority,

            @Description("Активен или нет")
            Boolean isActive
    ) {}
}
