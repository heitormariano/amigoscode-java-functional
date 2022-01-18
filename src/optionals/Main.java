package optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		String email01 = null;
		String email02 = "john@test.com.br";

		Optional.ofNullable(email01).ifPresentOrElse(email -> System.out.println("Sending email to " + email),
				() -> System.out.println("Cannot sending email"));

		Optional.ofNullable(email02).ifPresentOrElse(email -> System.out.println("Sending email to " + email),
				() -> System.out.println("Cannot sending email"));
	}
}
