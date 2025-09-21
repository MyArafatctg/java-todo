package com.example.todo.service;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.mapper.TodoMapper;
import com.example.todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoService {
    private TodoRepository todoRepository;
    private TodoMapper todoMapper;

    public Iterable<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> findTodoById(Long id){
        return todoRepository.findById(id);
    }

    public Todo createTodo(TodoDto todoDto){
        var todo = todoMapper.toTodo(todoDto);
        todoRepository.save(todo);
        return todo;
    }

    public Todo updateTodo(Long id, TodoDto todoDto){
        var todo = todoRepository.findById(id).orElse(null);
        if(todo == null){
            return null;
        }

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todoRepository.save(todo);
        return todo;
    }

    public Boolean deleteTodo(Long id){
        if(todoRepository.findById(id).isPresent()){
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
