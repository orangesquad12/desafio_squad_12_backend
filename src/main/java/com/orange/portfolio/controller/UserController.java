package com.orange.portfolio.controller;

import com.orange.portfolio.dtos.user.UserDTO;
import com.orange.portfolio.entities.User;
import com.orange.portfolio.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/image/{id}")
    public ResponseEntity uploadImage(@RequestPart(value = "image") MultipartFile file, @PathVariable Long id) {
        userService.uploadImage(file, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,
                                       @RequestBody @Valid UserDTO userDTO){
        var findUser = userService.findUserById(id);
        var saveUser = userService.save(findUser);
        return new ResponseEntity<>(saveUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
