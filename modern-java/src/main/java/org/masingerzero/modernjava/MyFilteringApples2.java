package org.masingerzero.modernjava;

import static java.util.stream.Collectors.toList;
import static org.masingerzero.modernjava.Color.GREEN;
import static org.masingerzero.modernjava.Color.RED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class MyFilteringApples2 {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN),
				new Apple(120, Color.RED));

//		List<Apple> greenApples = filterApples(inventory, MyFilteringApples2::isGreenApple);
//		System.out.println(greenApples);
//		
//		
//		List<Apple> heavyApples = filterApples(inventory, MyFilteringApples2::isHeavyApple);
//		System.out.println(heavyApples);

//		List<Apple> greenApples = filterApples(inventory, Apple::isGreenApple);
//		System.out.println(greenApples);
//
//		filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
//		filterApples(inventory, (Apple a) -> a.getWeight() > 150);
//		filterApples(inventory, (Apple a) -> a.getWeight() < 180 || RED.equals(a.getColor()));
//		
//		
//		List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
//				.collect(toList());
//		System.out.println(heavyApples);
//		List<Apple> heavyApplesParallelVersion = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
//		System.out.println(heavyApplesParallelVersion);
		
		prettyPrintApple(inventory, new PrintAppleWeight());
		prettyPrintApple(inventory, new PrintAppleInfo());
	}

	public static boolean isGreenApple(Apple apple) {
		return GREEN.equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formater) {
		for (Apple apple : inventory) {
			System.out.println(formater.format(apple));
		}
	}
}
