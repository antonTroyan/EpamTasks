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
		List keyList = new ArrayList(criteria.getCriteria().keySet());
		List valueList = new ArrayList(criteria.getCriteria().values());
		Scanner scanner = null;
		ArrayList<Object> data = new ArrayList<>();

		try {
			scanner = new Scanner(new FileReader("data//applianceData.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		while (scanner.hasNext()) {
			String analized = scanner.nextLine();
			Scanner scannerForTitle = new Scanner(analized);

			if (scannerForTitle.findInLine(criteria.getApplianceType()) != null) {
				int counter = 0;
				for (int i = 0; i < keyList.size(); i++) {
					Scanner scannerForString = new Scanner(analized);
					if (scannerForString.findInLine(keyList.get(i) + "="
							+ valueList.get(i).toString().toLowerCase()) != null) {
						counter++;
						if (counter == keyList.size()) {
							Scanner scannerParser = new Scanner(analized);
							scannerParser.useDelimiter(",|;|=");
							while (scannerParser.hasNext()) {
								scannerParser.useDelimiter(",|;|=");
								if (scannerParser.findInLine("=") != null) {
									data.add(scannerParser.next());
								} else {
									break;
								}
							}
						}
					} else {
						counter = 0;
					}
				}
			}
		}


		return createAppliance(criteria, data);
	}




	public <E> Appliance createAppliance (Criteria<E> criteria, ArrayList<Object> data){
		Appliance result;
		switch (criteria.getApplianceType()) {
			case "Laptop":
				result = new Laptop(Double.valueOf(data.get(0).toString()),
						data.get(1).toString(),
						Double.valueOf(data.get(2).toString()),
						Double.valueOf(data.get(3).toString()),
						Double.valueOf(data.get(4).toString()),
						Double.valueOf(data.get(5).toString()));
				break;
			case "Oven":
				result = new Oven(Double.valueOf(data.get(0).toString()),
						Double.valueOf(data.get(1).toString()),
						Double.valueOf(data.get(2).toString()),
						Double.valueOf(data.get(3).toString()),
						Double.valueOf(data.get(4).toString()),
						Double.valueOf(data.get(5).toString()));
				break;
			case "Refrigerator":
				result = new Refrigerator(Double.valueOf(data.get(0).toString()),
						Double.valueOf(data.get(1).toString()),
						Double.valueOf(data.get(2).toString()),
						Double.valueOf(data.get(3).toString()),
						Double.valueOf(data.get(4).toString()),
						Double.valueOf(data.get(5).toString()));
				break;
			case "Speakers":
				result = new Speakers(Double.valueOf(data.get(0).toString()),
						Double.valueOf(data.get(1).toString()),
						data.get(2).toString(),
						Double.valueOf(data.get(3).toString()));
				break;
			case "TabletPC":
				result = new TabletPC(Double.valueOf(data.get(0).toString()),
						Double.valueOf(data.get(1).toString()),
						Double.valueOf(data.get(2).toString()),
						Double.valueOf(data.get(3).toString()),
						data.get(4).toString());
				break;
			case "VacuumCleaner":
				result = new VacuumCleaner(Double.valueOf(data.get(0).toString()),
						data.get(1).toString(),
						data.get(2).toString(),
						data.get(3).toString(),
						Double.valueOf(data.get(4).toString()),
						Double.valueOf(data.get(5).toString()));
				break;
			default:
				result = null;
		}

		return result;

	}





	}
	// you may add your own code here


//you may add your own new classes
