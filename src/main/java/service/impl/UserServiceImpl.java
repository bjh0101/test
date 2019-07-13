package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.NeedCode;
import pojo.User;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public int deleteUser(NeedCode needCode) {
        int result = userMapper.deleteUser(needCode);
        return result;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
