package com.example.todoapi.repository;
import com.example.todoapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TodoRepository extends JpaRepository<Todo, Long>{
}