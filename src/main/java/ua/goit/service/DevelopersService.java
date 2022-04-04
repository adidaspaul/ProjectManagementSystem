package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.DevelopersConverter;
import ua.goit.model.dao.DevelopersDao;
import ua.goit.model.dto.DevelopersDto;

public class DevelopersService {

    private final DevelopersConverter converter;
    private final Repository<DevelopersDao> repository;

    public DevelopersService(DevelopersConverter converter, Repository <DevelopersDao> repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(DevelopersDto developers) {
        repository.save(converter.convert(developers));
    }

    public DevelopersDto findById(Integer id) {
        return converter.convert(repository.findById(id));
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public void update(DevelopersDto developers) {
        repository.update(converter.convert(developers));
    }
}
