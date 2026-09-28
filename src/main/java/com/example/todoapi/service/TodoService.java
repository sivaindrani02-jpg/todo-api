package com.example.todoapi.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todoapi.entity.Todo;
import com.example.todoapi.repository.TodoRepository;

@Service
public class TodoService{
    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository=todoRepository;
    }
    //get all todos
    public List<Todo>getAllTodos(){
        return todoRepository.findAll();
    }
    //get one todo
    public Optional<Todo>getTodoById(Long id){
        return todoRepository.findById(id);
    }
    // todo
    public Todo addTodo(Todo todo){
        return todoRepository.save(todo);
    }
    //update todo
    public Todo updateTodo(Long id,Todo todo){
        Todo existingTodo=todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setComplete(todo.isComplete());
        return todoRepository.save(existingTodo);
    }
    //Delete todo
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}
