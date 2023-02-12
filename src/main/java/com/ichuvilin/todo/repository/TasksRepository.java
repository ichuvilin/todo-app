package com.ichuvilin.todo.repository;

import com.ichuvilin.todo.model.Person;
import com.ichuvilin.todo.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    Optional<List<Tasks>> findByOwner(Person person);
}
