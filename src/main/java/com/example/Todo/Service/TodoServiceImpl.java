package com.example.Todo.Service;

import com.example.Todo.Dto.TodoDto;
import com.example.Todo.Model.Todo;
import com.example.Todo.Repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepo repo;
    @Override
    public String createTasks(TodoDto todoDto) {
        if(Objects.isNull(todoDto)){
            throw new RuntimeException("Null credentials");
        }

        Todo todo1 = new Todo();
        todo1.setTask(todoDto.getTask());
        todo1.setDescription(todoDto.getDescription());
        todo1.setStatus(todoDto.getStatus());
        repo.save(todo1);
        return "Task created successfully";
    }

    @Override
    public List<Todo> fetchAll() {
       return repo.findAll();
    }

    @Override
    public Todo fetchById(Integer id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
    }

    @Override
    public String updateById(Integer id, String status) {
        if (Objects.isNull(id) || Objects.isNull(status)){
            throw  new RuntimeException("Null credentials");
        }
        Todo todo = repo.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
        todo.setStatus(status);
        return "Task updated!";
    }

    @Override
    public String deleteRecord(Integer id) {
        if(Objects.isNull(id)){
            throw new RuntimeException("Null Id");
        }
         if(repo.existsById(id)) {
             repo.deleteById(id);
         }
         else {
             throw new RuntimeException("Id not found");
         }

        return "deleted !";
    }
}
