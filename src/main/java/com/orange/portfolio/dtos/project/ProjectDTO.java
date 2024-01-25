package com.orange.portfolio.dtos.project;

import com.orange.portfolio.dtos.user.UserDTO;

import java.util.List;

public record ProjectDTO(UserDTO user, String title, List<String> tags, String description, String image) {
}
