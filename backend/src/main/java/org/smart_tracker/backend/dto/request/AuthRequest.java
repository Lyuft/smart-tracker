package org.smart_tracker.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequest(
        @NotBlank(message = "Имя пользователя обязательно")
        @Size(min = 3, max = 50)
        String username,

        @NotBlank(message = "Пароль обязателен")
        @Size(min = 6, message = "Пароль должен быть не менее 6 символов")
        String password
) {}

