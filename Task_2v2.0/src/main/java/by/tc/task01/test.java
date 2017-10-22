package by.tc.task01;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.main.PrintApplianceInfo;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.FileFiller;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.validation.Validator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class test {
    public static void main(String[] args)  {

        Appliance appliance;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria<SearchCriteria.Oven> criteriaOven = new Criteria<SearchCriteria.Oven>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(SearchCriteria.Oven.CAPACITY, 32);
        System.out.println(Validator.criteriaValidator(criteriaOven));

}
}
