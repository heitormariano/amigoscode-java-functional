package finalsection;

import java.util.function.Consumer;

public class Callbacks {

	public static void main(String[] args) {

		Consumer<String> printInfo = value -> System.out.println("No lastName provided for " + value);
		hello("Michael", null, printInfo);

		Runnable printInfo2 = () -> System.out.println("No lastName provided");
		hello2("John", null, printInfo2);
	}

	static void hello(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if (lastName != null && !lastName.isEmpty()) {
			System.out.println(lastName);
		} else {
			callback.accept(firstName);
		}
	}

	static void hello2(String firstName, String lastName, Runnable callback) {
		System.out.println(firstName);
		if (lastName != null && !lastName.isEmpty()) {
			System.out.println(lastName);
		} else {
			callback.run();
		}
	}
}
