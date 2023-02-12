package com.ichuvilin.todo.controller;

import com.ichuvilin.todo.model.Tasks;
import com.ichuvilin.todo.service.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("todo") Tasks todo) {
        tasksService.addTask(todo);
        return "redirect:/person/" + todo.getOwner().getId() + "/todo";
    }

}
