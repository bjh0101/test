package controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.NeedCode;
import pojo.User;
import service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller

public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("userList")

    public String userList(Model model){
        List<User> userList=userService.selectAllUser();
        String s = JSONArray.fromObject(userList).toString();
        System.out.println(s);
        model.addAttribute("s",s);
        return "crud";
    }

    @RequestMapping("addUser")
    public String addUser(User user ){
        userService.addUser(user);
        return "crud";
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public int deleteUser(Integer[] id ){
        List<Integer> integers = Arrays.asList(id);
        NeedCode needCode = new NeedCode();
        needCode.setIds(integers);
        int result = userService.deleteUser(needCode);
        System.out.println(result);
        return result;
    }

    @RequestMapping("updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "crud";
    }
}
