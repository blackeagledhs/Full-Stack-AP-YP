package com.blackeagledhs.backendapnew.controller;

import com.blackeagledhs.backendapnew.entity.User;
import com.blackeagledhs.backendapnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable("idUser") Long idUser) {
        User user = userService.getIdUser(idUser).orElse(null);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody User userDto){
        User user = new User(userDto.getName(), userDto.getSurname(), userDto.getTitle(), userDto.getUrlImgprofile(), userDto.getUrlImgbanner(), userDto.getAboutme());
        userService.addUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PutMapping("/edit/{idUser}")
    public ResponseEntity<?> editUser(@PathVariable("idUser") Long idUser,
                                      @RequestBody User userDto) {

        User user = userService.getIdUser(idUser).orElse(null);

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setTitle(userDto.getTitle());
        user.setUrlImgprofile(userDto.getUrlImgprofile());
        user.setUrlImgbanner(userDto.getUrlImgbanner());
        user.setAboutme(userDto.getAboutme());

        userService.addUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<?> deleteUser(@PathVariable("idUser") Long idUser){
        userService.deleteUser(idUser);
        return new ResponseEntity(HttpStatus.OK);
    }

}
