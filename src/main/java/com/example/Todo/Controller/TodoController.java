package com.example.Todo.Controller;

import com.example.Todo.Dto.TodoDto;
import com.example.Todo.Model.Todo;
import com.example.Todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public ResponseEntity<String> createTask(@RequestBody TodoDto todoDto){
        String createdTask = todoService.createTasks(todoDto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> fetchAll(){
        return new ResponseEntity<>(todoService.fetchAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public ResponseEntity<Todo> fetchById(@PathVariable Integer id){
        return new ResponseEntity<>(todoService.fetchById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> upadteById(@PathVariable Integer id, @RequestBody String status){
        return new ResponseEntity<>(todoService.updateById(id, status),HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletedRecord(@PathVariable Integer id){
        return new ResponseEntity<>(todoService.deleteRecord(id),HttpStatus.OK);
    }

}

