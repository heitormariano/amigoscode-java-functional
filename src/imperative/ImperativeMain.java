package imperative;

import java.util.ArrayList;
import java.util.List;

public class ImperativeMain {

	public static void main(String[] args) {
		List<Person> people = List.of(new Person("Hector", 34), new Person("Keyth", 35), new Person("John", 16),
				new Person("Mathew", 17));

		System.out.println("All elements of list");
		for (Person person : people) {
			System.out.println(person.name + " " + person.age);
		}

		List<Person> overEighteenList = new ArrayList<>();

		for (Person person : people) {
			if (person.age >= 18) {
				overEighteenList.add(person);
			}
		}

		System.out.println("------------------------------------------");
		System.out.println("Over eighteen list");
		if (!overEighteenList.isEmpty()) {
			for (Person person : overEighteenList) {
				System.out.println("Name " + person.name + " - Age " + person.age);
			}
		} else {
			System.out.println("List empty");
		}
	}

	static class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
}
