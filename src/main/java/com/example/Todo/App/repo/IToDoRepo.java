package com.example.Todo.App.repo;

import com.example.Todo.App.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IToDoRepo extends JpaRepository<ToDo, Long> {

}
