package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {

		// Класс предок всех девайсов
		Appliance appliance;

		// Дай экземпляр фабрики
		ServiceFactory factory = ServiceFactory.getInstance();
		// Дай экземпляр имплементации общего для всех интерфейса ApplianceService
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

        // Создать объект критерий
		Criteria<Oven> criteriaOven = new Criteria<Oven>();
		// Задать тип с которым будет работать объект в дальнейшем
		criteriaOven.setApplianceType("Oven");
		// Установить критерии. Тип и значение
		criteriaOven.add(Oven.CAPACITY, 33);

		// Выполнить поиск по критериям
		appliance = service.find(criteriaOven);

		if(appliance.getClass() == by.tc.task01.entity.Oven.class) {}
		by.tc.task01.entity.Oven oven = (by.tc.task01.entity.Oven) appliance;
		//if(oven.getCapacity() == 3) {}

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria<Oven>();

        criteriaOven.setApplianceType("Oven");

		criteriaOven.add(Oven.HEIGHT, 40);
		criteriaOven.add(Oven.DEPTH, 60);
		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
        criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);

	}

}
