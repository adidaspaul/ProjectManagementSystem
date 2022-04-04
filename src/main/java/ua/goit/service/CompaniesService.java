package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.CompaniesConverter;
import ua.goit.model.dao.CompaniesDao;
import ua.goit.model.dto.CompaniesDto;

import java.util.List;
import java.util.stream.Collectors;

public class CompaniesService {


    private final CompaniesConverter converter;
    private final Repository<CompaniesDao> repository;

    public CompaniesService(CompaniesConverter converter, Repository <CompaniesDao> repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(CompaniesDto company) {
        repository.save(converter.convert(company));
    }

    public CompaniesDto findById(Integer id) {
        return converter.convert(repository.findById(id));
    }

    public void delete(CompaniesDto id) {
        repository.delete(converter.convert(id));
    }

    public void update(CompaniesDto company) {
        repository.update(converter.convert(company));
    }

    public List<CompaniesDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
