package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public User insertUser(User user) {
        System.out.println("insert ok....");
        return user;
    }
}
