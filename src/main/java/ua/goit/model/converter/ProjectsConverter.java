package ua.goit.model.converter;

import ua.goit.model.dao.ProjectsDao;
import ua.goit.model.dto.ProjectsDto;

public class ProjectsConverter {

    public ProjectsDto convert(ProjectsDao projDao){
        ProjectsDto projDto = new ProjectsDto();
        projDto.setId(projDao.getId());
        projDto.setProjectName(projDao.getProjectName());
        projDto.setStartDate(projDao.getStartDate());
        projDto.setCost(projDao.getCost());
        return projDto;
    }


    public ProjectsDao convert(ProjectsDto projDto){
        ProjectsDao projDao = new ProjectsDao();
        projDao.setId(projDto.getId());
        projDao.setProjectName(projDto.getProjectName());
        projDao.setStartDate(projDto.getStartDate());
        projDao.setCost(projDto.getCost());
        return projDao;
    }
}
