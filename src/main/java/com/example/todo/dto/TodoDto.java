package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class TodoDto {
    @NotBlank(message = "Title is required") //"" " "
    private String title;

    @NotBlank(message = "Description is required")
    private String description;
}
