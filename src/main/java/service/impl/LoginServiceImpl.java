package service.impl;

import dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Admin;
import service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public int login(Admin admin) {
        return loginMapper.login(admin);
    }
}
