package ua.goit.model.converter;

import ua.goit.model.dao.ProjectDevsSalarySumDao;
import ua.goit.model.dto.ProjectDevsSalarySumDto;


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
}
