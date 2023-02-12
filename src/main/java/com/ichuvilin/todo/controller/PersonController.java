package com.ichuvilin.todo.controller;

import com.ichuvilin.todo.model.Person;
import com.ichuvilin.todo.model.Tasks;
import com.ichuvilin.todo.service.PersonService;
import com.ichuvilin.todo.service.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final TasksService tasksService;

    public PersonController(PersonService personService, TasksService tasksService) {
        this.personService = personService;
        this.tasksService = tasksService;
    }


    @GetMapping("/{id}/todo")
    public String tasks(@PathVariable Long id, Model model) {
        Person person = personService.getPerson(id);

        Tasks todo = new Tasks();

        todo.setOwner(person);

        model.addAttribute("todo", todo);
        model.addAttribute("tasks", person.getTasks());

        return "person/tasks";
    }

}
