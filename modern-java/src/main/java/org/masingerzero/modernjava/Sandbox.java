package org.masingerzero.modernjava;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

public class Sandbox {

	public static void main(String[] args) {
		Function<String, Integer> f = (String s) -> s.length();

		ToIntBiFunction<String, String> ibf = (String r, String s) -> s.length() + r.length();

		Consumer<String> c = (String s) -> {
			s = s.concat("XXX");
			System.out.println(s);
		};
		
		///
		Supplier<List<String>> s = () -> Arrays.asList("one", "two", "three");
		
		BiFunction<Integer, Double, String> bf = (Integer i, Double d) -> String.format("i = %d and d= %d", i,d);
	}

}
