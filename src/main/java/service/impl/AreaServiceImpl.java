package service.impl;

import dao.AreaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Area;
import pojo.AreaIdName;
import service.AreaService;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaMapper areaMapper;

    @Override
    public List<AreaIdName> selectProvince() {

        return areaMapper.selectProvince();
    }

    @Override
    public List<AreaIdName> selectCity(int id) {
        return areaMapper.selectCity(id);
    }

    @Override
    public List<AreaIdName> selectCountry(int id) {
        return areaMapper.selectCountry(id);
    }
}
