package com.example.Todo.Service;

import com.example.Todo.Dto.TodoDto;
import com.example.Todo.Model.Todo;

import java.util.List;

public interface TodoService {
    String createTasks(TodoDto todoDto);

    List<Todo> fetchAll();

    Todo fetchById(Integer id);

    String updateById(Integer id, String status);

    String deleteRecord(Integer id);
}
