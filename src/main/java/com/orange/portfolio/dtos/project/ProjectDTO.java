package com.orange.portfolio.dtos.project;

import java.time.LocalDate;
import java.util.List;

public record ProjectDTO(Long userId, String title, List<String> tags, String description, String image, LocalDate date) {
}
