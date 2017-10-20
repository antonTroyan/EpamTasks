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
//        FileFiller ff = new FileFiller();
//        ff.fillFileDefault("data//applianceData.txt");

//        Oven oven = new Oven(1,12,5,6,7,5);
//        PrintApplianceInfo.print(oven);

        Appliance appliance;
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();
        Criteria<SearchCriteria.Oven> criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(SearchCriteria.Oven.CAPACITY, 33);


        System.out.println(criteriaOven.getCriteria().keySet());

        System.out.println(Validator.criteriaValidator(criteriaOven));

 //       appliance = service.find(criteriaOven);






//        Scanner scanner = new Scanner(new FileReader("data//applianceData.txt"));
//
//       // работает
//        while (scanner.hasNext()){
//            String str = scanner.next();
//            if(str.equals("Laptop")) {
//                System.out.println("Founded Laptop");
//                System.out.println("!!!!!!!!!!!!!" + scanner.findInLine("OS=Windows,"));
//            }
//        }


}
}
