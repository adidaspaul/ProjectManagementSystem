package ua.goit.model.converter;

import ua.goit.model.dao.ProjectDevsSalarySumDao;
import ua.goit.model.dao.SpecificProjectDevsDao;
import ua.goit.model.dto.ProjectDevsSalarySumDto;
import ua.goit.model.dto.SpecificProjectDevDto;


public class SumConverter {

        public ProjectDevsSalarySumDto convert(ProjectDevsSalarySumDao sum){
            ProjectDevsSalarySumDto total  = new ProjectDevsSalarySumDto();
            total.setProjectName(sum.getProjectName());
            total.setSum(sum.getSum());
            return total;
        }

        public ProjectDevsSalarySumDao convert(ProjectDevsSalarySumDto sum){
            ProjectDevsSalarySumDao total  = new ProjectDevsSalarySumDao();
            total.setProjectName(sum.getProjectName());
            total.setSum(sum.getSum());
            return total;
        }

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
