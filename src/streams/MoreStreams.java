package streams;

import static streams.MoreStreams.Gender.FEMALE;
import static streams.MoreStreams.Gender.MALE;

import java.util.List;
import java.util.function.Predicate;

public class MoreStreams {

	public static void main(String[] args) {
		List<Person> people = getPeopleList();

		Predicate<Person> personPredicate = person -> person.gender.equals(FEMALE);
		boolean containsOnlyFemales = people.stream().allMatch(personPredicate);
		System.out.println(containsOnlyFemales);

		boolean anyMatchFemales = people.stream().anyMatch(personPredicate);
		System.out.println(anyMatchFemales);

		boolean noneMatchFemales = people.stream().noneMatch(personPredicate);
		System.out.println(noneMatchFemales);

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
