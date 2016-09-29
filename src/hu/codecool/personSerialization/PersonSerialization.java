package hu.codecool.personSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersonSerialization{
	
	String filePath = "people.txt";
	
	public void write(List<Person> persons){

		if (persons.size() == 0) return;
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(persons);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void display(Language lang){
		List<Person> persons;
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object rawPersons = ois.readObject();
			persons = (List<Person>) rawPersons;
			printPersons(persons, lang);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void printPersons (List<Person> persons, Language lang){
		if (lang == Language.ENGLISH){
			for (Person person : persons) {
				System.out.println(person.getFirstName() + " " + person.getLastName() + ", age: " + person.getAge());
			}
		}
		else if (lang == Language.HUNGARIAN){
			for (Person person : persons) {
				System.out.println(person.getLastName() + " " + person.getFirstName() + ", age: " + person.getAge());
			}
		}
	}
}