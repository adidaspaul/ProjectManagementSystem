package ua.goit.model.converter;

import ua.goit.model.dao.CompaniesDao;
import ua.goit.model.dto.CompaniesDto;

public class CompaniesConverter {

    public CompaniesDto convert(CompaniesDao compDao){
        CompaniesDto compDto = new CompaniesDto();
        compDto.setId(compDao.getId());
        compDto.setCompanyName(compDao.getCompanyName());
        compDto.setCity(compDao.getCity());
        return compDto;
    }


    public CompaniesDao convert(CompaniesDto compDto){
        CompaniesDao compDao = new CompaniesDao();
        compDao.setId(compDto.getId());
        compDao.setCompanyName(compDto.getCompanyName());
        compDao.setCity(compDto.getCity());
        return compDao;
    }


}
