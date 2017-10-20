package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {

		Scanner scanner = null;

		try {
			scanner = new Scanner(new FileReader("data//applianceData.txt"));
		} catch (FileNotFoundException e) {
			System.err.println(e);
			scanner.close();
		}


		List keyList = new ArrayList(criteria.getCriteria().keySet());
		System.out.println("keyList" + keyList);

		List valueList = new ArrayList(criteria.getCriteria().values());
		System.out.println("valueList" + valueList);


		boolean founded = false;
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			Scanner scannerForTitle = new Scanner(str);

			if (scannerForTitle.findInLine(criteria.getApplianceType()) != null) {
				System.out.println(criteria.getApplianceType() + " - founded ");
				int counter = 0;
				for (int i = 0; i < keyList.size(); i++) {
					Scanner scannerForString = new Scanner(str);
					if (scannerForString.findInLine(keyList.get(i) + "=" + valueList.get(i) + ",") != null) {
						founded = true;
						System.out.println("criteria matches! - " + counter);
						counter++;
						if (counter == keyList.size()) {
							System.out.println("All ok!!!!!");
							return founded;

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
		return founded;




		// you may add your own code here


	}
}

	// you may add your own code here




// you may add your own new classes