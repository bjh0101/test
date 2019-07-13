package service;

import org.springframework.stereotype.Service;
import pojo.Admin;



public interface LoginService {
    int login(Admin admin);
}
