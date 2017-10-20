package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {

		criteria.getApplianceType();

		Scanner scanner = null;

		try {
			scanner = new Scanner(new FileReader("data//applianceData.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		List keyList = new ArrayList(criteria.getCriteria().keySet());
		System.out.println("keyList" + keyList);

		List valueList = new ArrayList(criteria.getCriteria().values());
		System.out.println("valueList" + valueList);


		while (scanner.hasNext()){
			String str = scanner.next();
			if(str.equals(criteria.getApplianceType())) {
				System.out.println("Founded " + criteria.getApplianceType());
				System.out.println("!!!!!!!!!!!!!"
						+ scanner.findInLine(keyList.get(0)
						+ "=" + valueList.get(0) + ","));
			}
		}

		// you may add your own code here

		return true;
	}

	// you may add your own code here







}

// you may add your own new classes