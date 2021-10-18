package functionalinterface;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		User lisa = new User("Lisa", "98484-2323");
		greetUser(lisa);
		greetUserConsumer.accept(lisa);
	}

	static class User {
		private final String name;
		private final String phoneNumber;

		User(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	}

	static void greetUser(User user) {
		System.out.println("Hello " + user.name + ", thanks for registering phone number " + user.phoneNumber);
	}

	static Consumer<User> greetUserConsumer = user -> System.out
			.println("Hello " + user.name + ", thanks for registering phone number " + user.phoneNumber);
}
