package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.UserDto;
import com.example.library.entity.User;
import com.example.library.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@Tag(name = "User API", description = "API untuk mengelola data user")
public class UserController {
     @Autowired
    private UserService userService;

    @Operation(summary = "Get all users", description = "Mengambil semua data user")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUser() != null ? new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Add a new user", description = "Menambahkan user baru")
    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto user) {
        return userService.addUser(user) != null ? new ResponseEntity<>("User berhasil ditambahkan", HttpStatus.CREATED) : new ResponseEntity<>("Gagal menambahkan user", HttpStatus.BAD_REQUEST);
    }
    
    @Operation(summary = "delete user", description = "Delete User")
    @DeleteMapping
    public ResponseEntity<?> addUser(@Valid @RequestParam long id) {
        return userService.getById(id) != null ? new ResponseEntity<>(userService.delteUser(id), HttpStatus.GONE) : new ResponseEntity<>("Gagal menambahkan user", HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Update a new user", description = "Mengupdate user")
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestParam long id ,@Valid @RequestBody UserDto user) {
        return userService.updateUser(id,user) != null ? new ResponseEntity<>("User berhasil diupdate", HttpStatus.CREATED) : new ResponseEntity<>("Gagal menambahkan user", HttpStatus.BAD_REQUEST);
    }
}
