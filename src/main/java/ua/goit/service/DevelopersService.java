package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.DevelopersConverter;
import ua.goit.model.dao.DevelopersDao;
import ua.goit.model.dto.DevelopersDto;

import java.util.List;
import java.util.stream.Collectors;

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

    public void delete(DevelopersDto id) {
        repository.delete(converter.convert(id));
    }

    public void update(DevelopersDto developers) {
        repository.update(converter.convert(developers));
    }

    public List<DevelopersDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
