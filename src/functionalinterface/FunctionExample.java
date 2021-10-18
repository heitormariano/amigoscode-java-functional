package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		// Function takes 1 argument and produdes 1 result
		int increment = incrementByOne(10);
		System.out.println(increment);

		int increment2 = incrementByOneFunction.apply(10);
		System.out.println("Function: " + increment2);

		int multiply = multiplyBy10Function.apply(increment2);
		System.out.println(multiply);

		Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
		System.out.println(addBy1AndThenMultiplyBy10.apply(4));

		// BiFunction takes 2 arguments and produces 1 result
		System.out.println(incrementByOneAndMultiply(9, 10));

		int resultBiFunction = incrementByOneAndMultiplyBiFunction.apply(9, 10);
		System.out.println("BiFunction: " + resultBiFunction);
	}

	// function
	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

	// traditional method
	static int incrementByOne(int number) {
		return number + 1;
	}

	// BiFunction
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (numberToIncrementByOne,
			numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

	// traditional method
	static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
		return (number + 1) * numToMultiplyBy;
	}
}
