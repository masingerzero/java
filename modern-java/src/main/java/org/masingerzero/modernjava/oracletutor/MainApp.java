package org.masingerzero.modernjava.oracletutor;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.JANUARY;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {

		List<Person> roster = Arrays.asList(new Person("Charly", of(1950, APRIL, 12), Person.Sex.MALE, "coco@gmail.es"),
				new Person("Carl", of(1965, JANUARY, 21), Person.Sex.MALE, "carl@gmail.es"),
				new Person("Elma", of(1990, AUGUST, 11), Person.Sex.FEMALE, "elma@gmail.es"),
				new Person("Mary", of(2000, APRIL, 1), Person.Sex.FEMALE, "mary@gmail.es"),
				new Person("Luisa", of(2005, APRIL, 17), Person.Sex.FEMALE, "luisa@gmail.es"),
				new Person("Lolo", of(2001, Month.SEPTEMBER, 20), Person.Sex.MALE, "lolo@gmail.es"));

		// Aproach 1
		PersonManager.printPersonsOlderThan(roster, 25);
		System.out.println("----------------------------------------------------------------------------------------");

		// Aproach 2
		PersonManager.printPersonsWithinAgeRange(roster, 15, 35);
		System.out.println("----------------------------------------------------------------------------------------");

		// Aproach 3
		PersonManager.printPersons(roster, new CheckPersonEligibleForSelectiveService());
		System.out.println("----------------------------------------------------------------------------------------");

		// Aproach 4
		PersonManager.printPersons(roster, new CheckPerson() {
			@Override
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		});
		System.out.println("----------------------------------------------------------------------------------------");

		// Aproach 5
		PersonManager.printPersons(roster,
				(Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
		System.out.println("----------------------------------------------------------------------------------------");

		// Aproach 6
		PersonManager.printPersonsWithPredicate(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
		System.out.println("----------------------------------------------------------------------------------------");

		// Aproach 7
		PersonManager.printPersons(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.printPerson());

		System.out.println("----------------------------------------------------------------------------------------");
		
		// Mio
		PersonManager.printFilteredList(roster, p -> p.getAge() > 50);

	}

}
