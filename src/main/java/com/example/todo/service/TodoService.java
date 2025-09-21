package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoService {
    private TodoRepository todoRepository;

    public Iterable<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> findTodoById(Long id){
        return todoRepository.findById(id);
    }
}
