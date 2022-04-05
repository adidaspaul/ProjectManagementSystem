package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.SkillsConverter;
import ua.goit.model.dao.SkillsDao;
import ua.goit.model.dto.SkillsDto;
import java.util.List;
import java.util.stream.Collectors;

public class SkillsService {

    private final SkillsConverter converter;
    private final Repository<SkillsDao> repository;

    public SkillsService(SkillsConverter converter, Repository <SkillsDao> repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(SkillsDto skills) {
    repository.findById(skills.getId()).ifPresent(skill -> {
        throw new IllegalArgumentException("Skill with id " + skills.getId() + " already exists");});
        repository.save(converter.convert(skills));
    }

    public SkillsDto findById(Integer id) {
        return converter.convert(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such skills")));
    }

    public void delete(SkillsDto id) {
        repository.delete(converter.convert(id));
    }

    public void update(SkillsDto skills) {
        repository.update(converter.convert(skills));
    }

    public List<SkillsDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}

