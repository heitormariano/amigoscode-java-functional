package imperative;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DeclarativeMain {

	public static void main(String[] args) {
		List<Person> people = List.of(new Person("Hector", 34), new Person("Keyth", 35), new Person("John", 16),
				new Person("Mathew", 17));

		System.out.println("over Eighteen");
		people.stream()
		.filter(person -> person.age >= 18)
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		//under Eighteen
		System.out.println("under Eighteen");
		Predicate<Person> underEighteen = person -> person.age < 18;
		Consumer<Person> printPerson = System.out::println;
		people.stream()
		.filter(underEighteen)
		.collect(Collectors.toList())
		.forEach(printPerson);

	}

	static class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return "Person [Name = " + this.name + ", Age = " + this.age + "]";
		}
	}
}
