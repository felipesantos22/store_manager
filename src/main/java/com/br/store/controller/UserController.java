package com.br.store.controller;

import com.br.store.entity.User;
import com.br.store.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User users = userService.createUserService(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.readUserService();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Optional<User>> findById(@PathVariable int id) {
        Optional<User> user = userService.readIdService(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Optional<User>> update(@PathVariable int id, @RequestBody User user) {
        Optional<User> users = userService.updateService(id, user);
        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> delete(@PathVariable int id){
        userService.deleteService(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item deletado!");
    }

}
