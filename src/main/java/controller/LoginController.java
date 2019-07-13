package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Admin;
import service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller

public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/show")
    public String show(Admin admin , HttpSession session,HttpServletRequest request){
        Cookie[] cookies=request.getCookies();

        if(cookies.length != 0 && cookies != null){
            for (Cookie c :
                    cookies) {
                if(c.getName().equals("kong")){
                    session.setAttribute("admin",admin.getUsername());
                    return "index";
                }
            }
        }


        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin , HttpSession session, HttpServletRequest request, HttpServletResponse response){

        String s= "";
        Cookie cookie = new Cookie("kong","kong");
            int login = loginService.login(admin);
            if (login == 1){
                session.setAttribute("admin",admin.getUsername());
            }
            s = "" + login;
            String result = request.getParameter("rememberMe");
            System.out.println("result:"+result);
            if(result.equals("true")){
                System.out.println("1");
                response.addCookie(cookie);
            }


        return s;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/crud")
    public String curd(){
        return "crud";
    }


}
