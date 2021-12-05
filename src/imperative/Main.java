package imperative;

import static imperative.Main.Gender.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Person> people = List.of(new Person("John", MALE), new Person("Mary", FEMALE), new Person("Richard", MALE),
				new Person("Peter", MALE), new Person("Ruth", FEMALE));

		System.out.println("Imperative Approach");

		// imperative approach
		List<Person> females = new ArrayList<>();

		for (Person person : people) {
			if (FEMALE.equals(person.gender)) {
				females.add(person);
			}
		}

		for (Person female : females) {
			System.out.println(female);
		}

		System.out.println("Declarative Approach");
		// declarative approach

		// using predicate object
		Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

		List<Person> femalesTwo = people.stream()
				.filter(personPredicate)
				.collect(Collectors.toList());
		
		femalesTwo.forEach(System.out::println);
	}

	static class Person {
		private final String name;
		private final Gender gender;

		Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}

	}

	enum Gender {
		MALE, FEMALE;
	}

}
