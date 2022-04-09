package ua.goit.model.converter;

import ua.goit.model.dto.ProjectDevsSalarySumDto;
import ua.goit.model.dao.ProjectDevsSalarySumDao;
import ua.goit.model.dao.SpecificProjectDevsDao;
import ua.goit.model.dto.SpecificProjectDevDto;
import ua.goit.model.dto.SyntaxDevsListDto;
import ua.goit.model.dao.SyntaxDevsListDao;


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

    public SyntaxDevsListDto convert(SyntaxDevsListDao devSyntax){
        SyntaxDevsListDto dev = new SyntaxDevsListDto();
        dev.setName(devSyntax.getName());
        dev.setSyntax(devSyntax.getSyntax());
        return dev;
    }

    public SyntaxDevsListDao convert(SyntaxDevsListDto devSyntax){
        SyntaxDevsListDao dev = new SyntaxDevsListDao();
        dev.setName(devSyntax.getName());
        dev.setSyntax(devSyntax.getSyntax());
        return dev;
    }
}
