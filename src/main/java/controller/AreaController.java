package controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Area;
import pojo.AreaIdName;
import service.AreaService;
import utils.JedisClient;

import java.util.List;

@Controller
public class AreaController {
    @Autowired
    AreaService areaService;

    @Autowired
    JedisClient jedisClient;

    @RequestMapping("showarea")
    public String show(){
        return "areajsp";
    }

    @RequestMapping("selectProvince")
    @ResponseBody
    public String selectProvince(){
        String s = "";
        s= jedisClient.get("province");

        if(s == null){
            System.out.println("1");
            List<AreaIdName> areas = areaService.selectProvince();
            s = JSONArray.fromObject(areas).toString();
            jedisClient.set("province",s);
            return s;
        }else{
            System.out.println("2");
            return s;
        }

    }

    @RequestMapping("selectCity")
    @ResponseBody
    public String selectCity(int id){
        String s = "";
        s= jedisClient.get("city"+id);

        if(s == null){
            System.out.println("1");
            List<AreaIdName> areas = areaService.selectCity(id);
            s = JSONArray.fromObject(areas).toString();
            jedisClient.set("city"+id,s);
            return s;
        }else{
            System.out.println("2");
            return s;
        }

    }

    @RequestMapping("selectCountry")
    @ResponseBody
    public String selectCountry(int id){
        String s = "";
        s= jedisClient.get("country"+id);

        if(s == null){
            System.out.println("1");
            List<AreaIdName> areas = areaService.selectCountry(id);
            s = JSONArray.fromObject(areas).toString();
            jedisClient.set("country"+id,s);
            return s;
        }else{
            System.out.println("2");
            return s;
        }

    }
}
