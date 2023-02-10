package com.ichuvilin.todo.service;

import com.ichuvilin.todo.model.Person;
import com.ichuvilin.todo.repository.PersonRepository;
import com.ichuvilin.todo.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;


    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> perons = personRepository.findByUsername(username);

        if (perons.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new PersonDetails(perons.get());
    }
}
