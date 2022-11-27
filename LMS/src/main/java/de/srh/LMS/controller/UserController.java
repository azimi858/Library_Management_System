package de.srh.LMS.controller;

import de.srh.LMS.entity.User;
import de.srh.LMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
// Data flow controller
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
    @DeleteMapping(path = "{userID}")
    public void deleteUser(@PathVariable("userID") Long userID){
        userService.deleteUser(userID);
    }
    @PutMapping(path = "{userID}")
    public void resetUserProfile(@PathVariable("userID") Long userID, @RequestBody User newUser){
        userService.resetUserProfile(userID, newUser);
    }
    @PatchMapping
    public void changeUserProfile(){

    }
}
