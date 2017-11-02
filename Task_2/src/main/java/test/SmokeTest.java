package test;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import static by.tc.task01.entity.criteria.SearchCriteria.*;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import org.testng.annotations.Test;


public class SmokeTest {

    private Appliance appliance;

    private ServiceFactory factory = ServiceFactory.getInstance();
    private ApplianceService service = factory.getApplianceService();

    @Test
    public void findOven() {


        Criteria<Oven> criteriaOven = new Criteria<Oven>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.POWER_CONSUMPTION, 1000);


        appliance = service.find(criteriaOven);

        by.tc.task01.entity.Oven oven = (by.tc.task01.entity.Oven)appliance;
        org.testng.Assert.assertEquals(oven.getPowerConsumption(), 1000, 0.0000000000001);
    }

    @Test
    public void findTabletPC() {
        Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
        criteriaTabletPC.setApplianceType("TabletPC");
        criteriaTabletPC.add(TabletPC.COLOR, "BLUE");

        appliance = service.find(criteriaTabletPC);
        by.tc.task01.entity.TabletPC tabletPC = (by.tc.task01.entity.TabletPC)appliance;
        org.testng.Assert.assertEquals(tabletPC.getColor().toUpperCase(), "BLUE");
    }
}
