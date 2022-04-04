package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.ProjectsConverter;
import ua.goit.model.dao.ProjectsDao;
import ua.goit.model.dto.ProjectsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectsService {

    private final ProjectsConverter converter;
    private final Repository<ProjectsDao> repository;

    public ProjectsService(ProjectsConverter converter, Repository <ProjectsDao> repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(ProjectsDto project) {
        repository.save(converter.convert(project));
    }

    public ProjectsDto findById(Integer id) {
        return converter.convert(repository.findById(id));
    }

    public void delete(ProjectsDto id) {
        repository.delete(converter.convert(id));
    }

    public void update(ProjectsDto project) {
        repository.update(converter.convert(project));
    }

    public List<ProjectsDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
