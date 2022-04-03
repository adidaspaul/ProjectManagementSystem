package ua.goit.model.converter;

import ua.goit.model.dao.DevelopersDao;
import ua.goit.model.dto.DevelopersDto;

public class DevelopersConverter {

    public DevelopersDto convert(DevelopersDao devDao){
    DevelopersDto devDto = new DevelopersDto();
    devDto.setId(devDao.getId());
    devDto.setName(devDao.getName());
    devDto.setSex(devDao.getSex());
    devDto.setSalary(devDao.getSalary());
    return devDto;
    }


    public DevelopersDao convert(DevelopersDto devDto){
    DevelopersDao devDao = new DevelopersDao();
    devDao.setId(devDto.getId());
    devDao.setName(devDto.getName());
    devDao.setSex(devDto.getSex());
    devDao.setSalary(devDto.getSalary());
    return devDao;
    }
}
