package ua.goit.service;

import ua.goit.dl.Repository;
import ua.goit.model.converter.ClientsConverter;
import ua.goit.model.dao.ClientsDao;
import ua.goit.model.dto.ClientsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ClientsService {

    private final ClientsConverter converter;
    private final Repository<ClientsDao> repository;

    public ClientsService(ClientsConverter converter, Repository <ClientsDao> repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(ClientsDto client) {
        repository.findById(client.getId()).ifPresent(customer -> {
            throw new IllegalArgumentException("Client with id " + customer.getId() + " already exists");});
        repository.save(converter.convert(client));
    }

    public ClientsDto findById(Integer id) {
        return converter.convert(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client with id " + id + " not found")));
    }


    public void update(ClientsDto client) {
        repository.update(converter.convert(client));
    }

    public List<ClientsDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
