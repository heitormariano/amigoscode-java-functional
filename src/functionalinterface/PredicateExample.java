package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {

		String phoneNumberTest01 = "07123456789";
		String phoneNumberTest02 = "08123456789";

		String phoneNumberTest03 = "07111222333";
		String phoneNumberTest04 = "09111222";

		System.out.println(isPhoneNumberValid(phoneNumberTest01));
		System.out.println(isPhoneNumberValid(phoneNumberTest02));

		System.out.println(isPhoneNumberValidPredicate.test(phoneNumberTest03));
		System.out.println(isPhoneNumberValidPredicate.test(phoneNumberTest04));

		System.out.println("Is phone number valid and contains number 3 = "
				+ isPhoneNumberValidPredicate.and(containsNumber3Predicate).test(phoneNumberTest01));

		System.out.println("Is phone number valid and contains number 3 = "
				+ isPhoneNumberValidPredicate.and(containsNumber3Predicate).test(phoneNumberTest04));

		System.out.println("BiPredicate Tests");
		System.out.println(checkPhoneNumber.test(phoneNumberTest01, 11));
		System.out.println(checkPhoneNumber.test(phoneNumberTest02, 11));
		System.out.println(checkPhoneNumber.test(phoneNumberTest03, 11));
		System.out.println(checkPhoneNumber.test(phoneNumberTest04, 11));
	}

	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
	}

	static boolean containsNumber3(String phoneNumber) {
		return phoneNumber.contains("3");
	}

	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07")
			&& phoneNumber.length() == 11;

	static Predicate<String> containsNumber3Predicate = phoneNumber -> phoneNumber.contains("3");

	// BiPredicate
	static BiPredicate<String, Integer> checkPhoneNumber = (phoneNumber,
			digitsQuantity) -> phoneNumber.length() == digitsQuantity;

}
