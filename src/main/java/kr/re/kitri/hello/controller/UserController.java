package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.User;
import kr.re.kitri.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //post는 사용자 등록으로 간주한다.
    @PostMapping("/users")
    public void registerUser(@RequestBody User user) {
        System.out.println(user);
        userService.registUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User viewUserDetails(@PathVariable String userId) {

        return userService.getUserDetails(userId);
    }
}
