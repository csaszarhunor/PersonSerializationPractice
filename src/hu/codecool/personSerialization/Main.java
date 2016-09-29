package hu.codecool.personSerialization;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Person p1 = new Person("Hunor", "Csaszar", 26);
		Person p2 = new Person("Tamas", "Csaszar", 25);
		Person p3 = new Person("Hunor", "Kiss", 67);
		
		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		PersonSerialization pr = new PersonSerialization();
		
		pr.write(persons);
		pr.display(Language.ENGLISH);
		pr.display(Language.HUNGARIAN);
	}
}
