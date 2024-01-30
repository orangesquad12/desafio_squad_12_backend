package com.orange.portfolio.dtos.user;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(@NotEmpty(message = "Mandatory field") String email, String password) {
}
