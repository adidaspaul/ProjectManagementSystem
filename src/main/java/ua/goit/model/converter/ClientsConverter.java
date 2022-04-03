package ua.goit.model.converter;

import ua.goit.model.dao.ClientsDao;
import ua.goit.model.dto.ClientsDto;

public class ClientsConverter {

    public ClientsDto convert(ClientsDao clientDao){
        ClientsDto clientDto = new ClientsDto();
        clientDto.setId(clientDao.getId());
        clientDto.setName(clientDao.getName());
        clientDto.setCountry(clientDao.getCountry());
        clientDto.setCategory(clientDao.getCategory());

        return clientDto;
    }


    public ClientsDao convert(ClientsDto clientDto){
        ClientsDao clientDao = new ClientsDao();
        clientDao.setId(clientDto.getId());
        clientDao.setName(clientDto.getName());
        clientDao.setCountry(clientDto.getCountry());
        clientDao.setCategory(clientDto.getCategory());
        return clientDao;
    }
}
