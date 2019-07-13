package dao;

import pojo.Area;
import pojo.AreaIdName;

import java.util.List;

public interface AreaMapper {
    List<AreaIdName> selectProvince();

    List<AreaIdName> selectCity(int id);

    List<AreaIdName> selectCountry(int id);
}
