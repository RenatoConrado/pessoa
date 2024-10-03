package com.backend.person.controller;

import com.backend.person.dto.PersonDTO;
import com.backend.person.entity.Person;
import com.backend.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        Person p = new Person();
        p.setName(personDTO.getName());
        p.setCpf(personDTO.getCpf());
        p.setAge(personDTO.getAge());

        Person save = personRepository.save(p);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonByID(@PathVariable UUID id) {
        Optional<Person> foundPerson = personRepository.findById(id);

        return foundPerson.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
