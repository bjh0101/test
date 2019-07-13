package dao;

import pojo.NeedCode;
import pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAllUser();

    int deleteUser(NeedCode needCode);
}
