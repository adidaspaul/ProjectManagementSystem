package ua.goit.model.converter;

import ua.goit.model.dao.SpecificProjectDevsDao;
import ua.goit.model.dto.SpecificProjectDevDto;

public class SpecificProjectDevConverter {

    public SpecificProjectDevDto convert(SpecificProjectDevsDao dever){
        SpecificProjectDevDto dev = new SpecificProjectDevDto();
        dev.setName(dever.getName());
        dev.setProjectName(dever.getProjectName());
        return dev;
    }

    public SpecificProjectDevsDao convert(SpecificProjectDevDto dever){
        SpecificProjectDevsDao dev = new SpecificProjectDevsDao();
        dev.setName(dever.getName());
        dev.setProjectName(dever.getProjectName());
        return dev;
    }
}
