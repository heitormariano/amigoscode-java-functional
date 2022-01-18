package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

	public static void main(String[] args) {

		Function<String, String> upperCaseName = name -> name.toUpperCase();

		Function<String, String> lowCaseName = name -> {
			if (name.isBlank())
				throw new IllegalArgumentException("Invalid name");
			return name.toLowerCase();
		};

		BiFunction<String, Integer, String> printInfo = (name, age) -> {
			String info = "Name:" + (name != null ? name : "Not provided") + "\nAge:"
					+ (age != null ? age : "Not provided");
			return info;
		};

		System.out.println(upperCaseName.apply("hector"));
		System.out.println(lowCaseName.apply("MARK"));
		System.out.println(printInfo.apply("John", 36));
		System.out.println(printInfo.apply("Carlos", null));

	}
}