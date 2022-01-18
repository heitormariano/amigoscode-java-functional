package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		User lisa = new User("Lisa", "85 98484-2323");
		greetUser(lisa);
		greetUserConsumer.accept(lisa);

		User hector = new User("Hector", "84 98383-3838");

		greetUserTwoArguments(hector, false);
		greetUserTwoArgumentsConsumer.accept(hector, true);
	}

	static void greetUser(User user) {
		System.out.println("Hello " + user.name + ", thanks for registering phone number " + user.phoneNumber);
	}

	static Consumer<User> greetUserConsumer = user -> System.out
			.println("Hello " + user.name + ", thanks for registering phone number " + user.phoneNumber);

	static void greetUserTwoArguments(User user, boolean showPhoneNumber) {
		System.out.println("Hello " + user.name + ", thanks for registering phone number "
				+ (showPhoneNumber ? user.phoneNumber : "***********"));
	}

	static BiConsumer<User, Boolean> greetUserTwoArgumentsConsumer = (user, showPhoneNumber) -> System.out
			.println("Hello " + user.name + ", thanks for registering phone number "
					+ (showPhoneNumber ? user.phoneNumber : "***********"));

	static class User {
		private final String name;
		private final String phoneNumber;

		User(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	}
}
