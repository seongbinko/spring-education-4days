package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.User;
import kr.re.kitri.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //post는 사용자 등록으로 간주한다.
    @PostMapping("/users")
    public User registerUser(@RequestBody User user) {
        System.out.println(user);
        return userService.registUser(user);
    }
}
