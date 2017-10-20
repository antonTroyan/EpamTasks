package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {
	
	private String applianceType;

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public String getApplianceType() {
		return applianceType;
	}

	public void setApplianceType(String applianceType) {
		this.applianceType = applianceType;
	}

	public Map<E, Object> getCriteria() {
		return criteria;
	}

	public Object getValue (E searchCriteria) {

		return criteria.get(searchCriteria);
	}

	public <E> Class<SearchCriteria> getSearchCriteria (){
		return SearchCriteria.class;
	}

	// you may add your own code here

}
