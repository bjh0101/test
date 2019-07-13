package service;

import pojo.NeedCode;
import pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();

    int deleteUser(NeedCode needCode);

    void addUser(User user);

    void updateUser(User user);
}
