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

        ////////////////////////////////////////////////////////////////

        Criteria<SearchCriteria.TabletPC> criteriaTabletPC = new Criteria<>();
        criteriaTabletPC.setApplianceType("TabletPC");
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR, "RED");
        criteriaTabletPC.add(SearchCriteria.TabletPC.BATTERY_CAPACITY, 4);
        appliance = service.find(criteriaTabletPC);
        PrintApplianceInfo.print(appliance);

        ///////////////////////////////////////////////////////////////

        Criteria<SearchCriteria.Speakers> speakersCriteria = new Criteria<>();
        speakersCriteria.setApplianceType("Speakers");
        speakersCriteria.add(SearchCriteria.Speakers.FREQUENCY_RANGE, "2-4");
        speakersCriteria.add(SearchCriteria.Speakers.CORD_LENGTH, 2);
        appliance = service.find(speakersCriteria);
        PrintApplianceInfo.print(appliance);

}
}
