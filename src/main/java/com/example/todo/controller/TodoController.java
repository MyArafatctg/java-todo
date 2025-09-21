package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;
    private final TodoService todoService;

    @GetMapping
    public Iterable<Todo> getTodos(){
        return todoService.getTodos();
    };

    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable Long id){
        return todoService.findTodoById(id);
    }
}
