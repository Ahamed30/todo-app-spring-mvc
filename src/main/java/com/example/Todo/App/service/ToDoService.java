package com.example.Todo.App.service;

import com.example.Todo.App.repo.IToDoRepo;
import com.example.Todo.App.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    IToDoRepo toDoRepo;

    public List<ToDo> getAllToDoItems() {
        return new ArrayList<>(toDoRepo.findAll());
    }

    public ToDo getToDoItemById(Long id) {
        Optional<ToDo> todo = toDoRepo.findById(id);
        return todo.orElse(null);
    }

    public boolean updateStatus(Long id) {
        ToDo todo = getToDoItemById(id);
        todo.setStatus("Completed");

        return saveOrUpdateToDoItem(todo);
    }

    public boolean saveOrUpdateToDoItem(ToDo todo) {
        ToDo updatedToDo = toDoRepo.save(todo);
        return getToDoItemById(updatedToDo.getId()) != null;
    }

    public boolean deleteToDoItem(Long id) {
        toDoRepo.deleteById(id);
        return toDoRepo.findById(id).isEmpty();
    }
}
