package kr.re.kitri.hello.service;

import kr.re.kitri.hello.dao.UserDao;
import kr.re.kitri.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void registUser(User user) {
        userDao.insertUser(user);
    }

    public List<User> getAllUsers() {
        //double a = 3/0;
//        int[] arr = {1,2,3};
//        int b = arr[3];
        return userDao.selectAllUsers();
    }

    public User getUserDetails(String userId) {
        return userDao.selectUserByUserId(userId);
    }
}
