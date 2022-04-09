package ua.goit.model.converter;

import ua.goit.model.dao.*;
import ua.goit.model.dto.*;


public class QueryConverter {

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

    public DevsRankListDao convert (DevsRankListDto devsRank){
        DevsRankListDao dev = new DevsRankListDao();
        dev.setName(devsRank.getName());
        dev.setRank(devsRank.getRank());
        return dev;
    }

    public DevsRankListDto convert (DevsRankListDao devsRank){
        DevsRankListDto dev = new DevsRankListDto();
        dev.setName(devsRank.getName());
        dev.setRank(devsRank.getRank());
        return dev;
    }

    public ProjectDateDevsDao convert (ProjectDateDevsDto projectDate){
        ProjectDateDevsDao project = new ProjectDateDevsDao();
        project.setStartDate(projectDate.getStartDate());
        project.setProjectName(projectDate.getProjectName());
        project.setCount(projectDate.getCount());

        return project;
    }

    public ProjectDateDevsDto convert (ProjectDateDevsDao projectDate){
        ProjectDateDevsDto project = new ProjectDateDevsDto();
        project.setStartDate(projectDate.getStartDate());
        project.setProjectName(projectDate.getProjectName());
        project.setCount(projectDate.getCount());
        return project;
    }
}
