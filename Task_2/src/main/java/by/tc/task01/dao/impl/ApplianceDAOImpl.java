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
		ArrayList<Object> data = new ArrayList<>();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader("data//applianceData.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List keyList = new ArrayList(criteria.getCriteria().keySet());
		List valueList = new ArrayList(criteria.getCriteria().values());


		boolean founded = false;
		while (scanner.hasNext()) {
			String analized = scanner.nextLine();
			Scanner scannerForTitle = new Scanner(analized);

			if (scannerForTitle.findInLine(criteria.getApplianceType()) != null) {
				System.out.println(criteria.getApplianceType() + " - founded ");
				int counter = 0;
				for (int i = 0; i < keyList.size(); i++) {
					Scanner scannerForString = new Scanner(analized);
					if (scannerForString.findInLine(keyList.get(i) + "=" + valueList.get(i) + ",") != null) {
						founded = true;
						System.out.println("criteria matches! - " + counter);
						counter++;
						if (counter == keyList.size()) {
							System.out.println("All ok!!!!!");
							Scanner scannerParser = new Scanner(analized);
							scannerParser.useDelimiter(",|;|=");

							while (scanner.hasNext()) {
								scanner.useDelimiter(",|;|=");
								if (scanner.findInLine("=") != null) {
									data.add(scanner.next());
								} else {
									break;
								}
							}
						}
					} else {
						counter = 0;
						System.out.println("criteria don`t matches");
					}
				}
			} else {
				System.out.println(criteria.getApplianceType() + " not founded !");
				founded = false;
			}
		}



		for(Object obj: data){
			System.out.println(obj);
		}
		System.out.println(data.get(0) + "!!!!!!!!!!");

		System.out.println(data.size() + "size");


		switch (criteria.getApplianceType()) {
			case "Laptop":
				result = new Laptop(Double.valueOf(data.get(0).toString()),
						data.get(1).toString(),
						Double.valueOf(data.get(2).toString()),
						Double.valueOf(data.get(3).toString()),
						Double.valueOf(data.get(4).toString()),
						Double.valueOf(data.get(5).toString()));
//				result = new Laptop(1.2, "dsf", 5.2,
//						9.3, 2, 1);
				break;
			case "Oven":
				result = new Oven(1,1,1,1,1,1);
				break;
			case "Refrigerator":
				result = new Refrigerator(1,1,1,1,1,1);
				break;
			case "Speakers":
				result = new Speakers(1,1,"12-5",1);
				break;
			case "TabletPC":
				result = new TabletPC(1,1,1,1, "Sssd");
				break;
			case "VacuumCleaner":
				result = new VacuumCleaner(1, "sd", "dsa",
						"dsa",1,2);
				break;
			default:
				result = null;

		}

		return result;
	}
	
	// you may add your own code here

}


//you may add your own new classes
