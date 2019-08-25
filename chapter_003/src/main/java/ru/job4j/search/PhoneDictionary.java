package ru.job4j.search;

import java.util.List;
import java.util.ArrayList;

public class PhoneDictionary {
	private List<Person> persons = new ArrayList<Person>(); 
	public void add(Person person) {
		this.persons.add(person);
	}
	
	public List<Person> find(String key) {
		List<Person> result = new ArrayList();
		for (int i = 0; i < persons.size(); i++) {
			if ((persons.get(i).getName().contains(key)) || (persons.get(i).getSurname().contains(key)) || (persons.get(i).getPhone().contains(key)) || (persons.get(i).getAddress().contains(key))) {
				result.add(persons.get(i));
			}	
		}
		return result; 
	}	
}