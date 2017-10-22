package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.FileFiller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {

		FileFiller fileFiller = new FileFiller();
		fileFiller.fillFileDefault("data//applianceData.txt");

		Scanner scanner = null;

		try {
			scanner = new Scanner(new FileReader("data//applianceData.txt"));
		} catch (FileNotFoundException e) {
			System.err.println(e);
			scanner.close();
		}

		List keyList = new ArrayList(criteria.getCriteria().keySet());
		List valueList = new ArrayList(criteria.getCriteria().values());

		boolean founded = false;

		if(criteria.getApplianceType() != null){
			while (scanner.hasNext()) {
				String analized = scanner.nextLine();
				Scanner scannerForTitle = new Scanner(analized);
				if (scannerForTitle.findInLine(criteria.getApplianceType()) != null) {
					int counter = 0;
					for (int i = 0; i < keyList.size(); i++) {
						Scanner scannerForString = new Scanner(analized);
						if (scannerForString.findInLine(keyList.get(i) + "="
								+ valueList.get(i).toString().toLowerCase() + "[,;]") != null) {
							founded = true;
							counter++;
							if (counter == keyList.size()) {
								return founded;
							}
						} else {
							counter = 0;
						}
					}
				} else {
					founded = false;
				}
			}
		} else {
			while (scanner.hasNext()){
				String analized = scanner.nextLine();
				int counter = 0;
				for (int i = 0; i < keyList.size(); i++) {
					Scanner scannerForString = new Scanner(analized);
					if (scannerForString.findInLine(keyList.get(i) + "="
							+ valueList.get(i).toString().toLowerCase() + "[,;]") != null) {
						founded = true;
						counter++;
						if (counter == keyList.size()) {
							return founded;
						}
					} else {
						counter = 0;
					}
				}
			}
		}






		return founded;
	}
}





