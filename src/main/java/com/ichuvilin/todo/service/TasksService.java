package com.ichuvilin.todo.service;

import com.ichuvilin.todo.model.Person;
import com.ichuvilin.todo.model.Tasks;
import com.ichuvilin.todo.repository.PersonRepository;
import com.ichuvilin.todo.repository.TasksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;
    private final PersonRepository personRepository;

    public TasksService(TasksRepository tasksRepository, PersonRepository personRepository) {
        this.tasksRepository = tasksRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public void addTask(Tasks todo) {
        todo.setCompleted(false);
        Person person = personRepository.findById(todo.getOwner().getId()).orElse(null);
        if (person != null)
            person.setTasks(new ArrayList<>(Collections.singleton(todo)));
        tasksRepository.save(todo);
    }
}
