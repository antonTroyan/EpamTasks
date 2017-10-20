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
    public static void main(String[] args) throws FileNotFoundException {


        Appliance appliance;
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();
        Criteria<SearchCriteria.Oven> criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(SearchCriteria.Oven.WEIGHT, 12);
        criteriaOven.add(SearchCriteria.Oven.DEPTH, 60);
        criteriaOven.add(SearchCriteria.Oven.CAPACITY, 33);
        criteriaOven.add(SearchCriteria.Oven.HEIGHT, 45);

        System.out.println(criteriaOven.getCriteria().keySet());

        System.out.println(Validator.criteriaValidator(criteriaOven));


//        Scanner scanner = new Scanner(new FileReader("data//applianceData.txt"));
//        scanner.useDelimiter(",|;|=");
//
//        while(scanner.hasNext()){
//            if(scanner.findInLine("=") != null){
//                System.out.println(scanner.next());
//            }
//            else{
//                System.out.println();
//                scanner.next();
//            }
//        }



//
//    scanner.close();

}
}
