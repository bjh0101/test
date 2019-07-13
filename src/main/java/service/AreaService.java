package service;

import pojo.Area;
import pojo.AreaIdName;

import java.util.List;

public interface AreaService {
    List<AreaIdName> selectProvince();

    List<AreaIdName> selectCity(int id);

    List<AreaIdName> selectCountry(int id);
}
