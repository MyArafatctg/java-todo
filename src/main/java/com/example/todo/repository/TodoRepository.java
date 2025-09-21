package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository <Todo, Long> {
}
