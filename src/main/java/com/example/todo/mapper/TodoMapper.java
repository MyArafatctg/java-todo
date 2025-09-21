package com.example.todo.mapper;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    @Mapping(target = "create_at", ignore = true)
    Todo toTodo(TodoDto todoDto);
}
