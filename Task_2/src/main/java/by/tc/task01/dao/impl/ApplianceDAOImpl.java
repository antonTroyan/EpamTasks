package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplianceDAOImpl implements ApplianceDAO {


	public <E> Appliance find(Criteria<E> criteria) {

		Appliance result;

		try(Scanner scanner = new Scanner(new FileReader("data//applianceData.txt"))){
			List keyList = new ArrayList(criteria.getCriteria().keySet());
			List valueList = new ArrayList(criteria.getCriteria().values());

			while (scanner.hasNext()){
				String typeAppliance = scanner.next();
				if(typeAppliance.equals(criteria.getApplianceType())) {
					String resultString;
					System.out.println("Founded " + criteria.getApplianceType());
					System.out.println("!!!!!!!!!!!!!"
							+ scanner.findInLine(keyList.get(0)
							+ "=" + valueList.get(0) + ","));
					resultString = scanner.nextLine();
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}


//		switch (criteria.getApplianceType()) {
//			case "Laptop":
//				result = new Laptop(0,0,0,0,0,0,);
//				break;
//			case "Oven":
//				result = new Oven();
//				break;
//			case "Refrigerator":
//				result = new Refrigerator();
//				break;
//			case "Speakers":
//				result = new Speakers();
//				break;
//			case "TabletPC":
//				result = new TabletPC();
//				break;
//			case "VacuumCleaner":
//				result = new VacuumCleaner();
//				break;
//			default:
//				result = null;
//
//		}

		return null;
	}
	
	// you may add your own code here

}


//you may add your own new classes
