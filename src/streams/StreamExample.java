package streams;

import static streams.StreamExample.Gender.FEMALE;
import static streams.StreamExample.Gender.MALE;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		List<Person> people = getPeopleList();

		// Set<Gender> genders = people.stream().map(person ->
		// person.gender).collect(Collectors.toSet());
		// genders.forEach(gender -> System.out.println(gender));

		System.out.println("Genders:");
		people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(System.out::println);

		System.out.println("Names:");
		people.stream().map(person -> person.name).collect(Collectors.toSet()).forEach(System.out::println);

		System.out.println("Length of Names");
		people.stream().map(person -> person.name).mapToInt(String::length).forEach(System.out::println);
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

	static List<Person> getPeopleList() {
		List<Person> people = List.of(new Person("John", MALE), new Person("Mary", FEMALE), new Person("Richard", MALE),
				new Person("Peter", MALE), new Person("Ruth", FEMALE));

		return people;
	}
}
