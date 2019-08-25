package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class PhoneDictionaryTest {
	@Test
	public void whenFindByName() {
		PhoneDictionary phones = new PhoneDictionary();
			phones.add(new Person("Ivan", "Ivanov", "89164343434", "Kursk"));
			phones.add(new Person("Pavel", "Petrov", "89163343434", "Novosibirsk"));
			List<Person> persons = phones.find("Pavel");
			assertThat(persons.iterator().next().getSurname(), is("Petrov"));
	}

	@Test
	public void whenFindBySurname() {
		PhoneDictionary phones = new PhoneDictionary();
			phones.add(new Person("Ivan", "Ivanov", "89164343434", "Kursk"));
			phones.add(new Person("Pavel", "Petrov", "89163343434", "Novosibirsk"));
			List<Person> persons = phones.find("Petr");
			assertThat(persons.iterator().next().getName(), is("Pavel"));
	}
	@Test
	public void whenFindByPhone() {
		PhoneDictionary phones = new PhoneDictionary();
			phones.add(new Person("Ivan", "Ivanov", "89164343434", "Kursk"));
			phones.add(new Person("Pavel", "Petrov", "89163343434", "Novosibirsk"));
			List<Person> persons = phones.find("89163343");
			assertThat(persons.iterator().next().getAddress(), is("Novosibirsk"));
	}	
	@Test
	public void whenFindByAddress() {
		PhoneDictionary phones = new PhoneDictionary();
			phones.add(new Person("Ivan", "Ivanov", "89164343434", "Kursk"));
			phones.add(new Person("Pavel", "Petrov", "89163343434", "Novosibirsk"));
			List<Person> persons = phones.find("Kursk");
			assertThat(persons.iterator().next().getPhone(), is("89164343434"));
	}
	@Test
	public void whenFindPhoneByAddress() {
		PhoneDictionary phones = new PhoneDictionary();
			phones.add(new Person("Ivan", "Ivanov", "89164343434", "Kursk"));
			phones.add(new Person("Pavel", "Petrov", "89163343434", "Novosibirsk"));
			List<Person> persons = phones.find("Kursk");
			assertThat(persons.iterator().next().getSurname(), is("Ivanov"));
	}
	
	
}