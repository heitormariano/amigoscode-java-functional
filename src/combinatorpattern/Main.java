package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer("Mark", "mark@gmail.com", "+084956568787", LocalDate.of(1985, 4, 26));

		// boolean result = new CustomerValidatorService().isValid(customer);
		// System.out.println("Result: " + (result ? "Valid" : "Not Valid"));

		ValidationResult result = isEmailValid().and(isPhoneNumberValid()).and(isAnAdult()).apply(customer);
		System.out.println("Result: " + result);

		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
	}
}
