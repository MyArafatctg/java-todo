package com.example.todo.controller;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody TodoDto todoDto){
        var todo = todoService.createTodo(todoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(
            @PathVariable(name = "id") Long id,
            @RequestBody TodoDto todoDto)
    {
        var todo = todoService.updateTodo(id, todoDto);
        if (todo != null){
            return ResponseEntity.ok(todoDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable(value = "id") Long id){
        if (todoService.deleteTodo(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
