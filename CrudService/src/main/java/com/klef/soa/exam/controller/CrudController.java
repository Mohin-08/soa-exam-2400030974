package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.exam.entity.Crud;
import com.klef.soa.exam.service.CrudService;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private CrudService service;

    @GetMapping("/")
    public String demo() {
        return "Spring Boot Project";
    }

    @PostMapping("/add")
    public ResponseEntity<Crud> addUser(@RequestBody Crud c) {
        Crud crud = service.addUser(c);
        return ResponseEntity.status(201).body(crud);
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<Crud>> displayAllUsers() {
        List<Crud> records = service.displayAllUsers();
        return ResponseEntity.status(200).body(records);
    }

    @GetMapping("/display")
    public ResponseEntity<?> displayUserById(@RequestParam Long id) {
        Crud crud = service.displayUsersById(id);

        if (crud != null) {
            return ResponseEntity.status(200).body(crud);
        } else {
            return ResponseEntity.status(404).body("Learning Module ID Not Found");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        String message = service.deleteUserById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
