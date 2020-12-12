package org.masingerzero.modernjava;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import javax.swing.Action;

public class Sandbox {

	private int aNumber = 10;

	public static void main(String[] args) {
		Function<String, Integer> f = (String s) -> s.length();

		ToIntBiFunction<String, String> ibf = (String r, String s) -> s.length() + r.length();

		Consumer<String> c = (String s) -> {
			s = s.concat("XXX");
			System.out.println(s);
		};

		///
		Supplier<List<String>> s = () -> Arrays.asList("one", "two", "three");

		BiFunction<Integer, Double, String> bf = (Integer i, Double d) -> String.format("i = %d and d= %d", i, d);

//		Object o = () -> {System.out.println("Tricky!!!!");}; // This won't compile.

		Object o = (Runnable) () -> {
			System.out.println("this work!!!");
		};

		int portNumber = 111111;
		Runnable r = () -> System.out.println();
		// portNumber = 0;
		
		Sandbox sb = new Sandbox();
		sb.execute();
	}

	public int getaNumber() {
		return aNumber;
	}

	public void setaNumber(int aNumber) {
		this.aNumber = aNumber;
	}

	public void execute() {
		
		Runnable r = () -> {
			System.out.println("running");
			System.out.println(this);
			System.out.println(this.aNumber);
		};
		r.run();
	}

}
