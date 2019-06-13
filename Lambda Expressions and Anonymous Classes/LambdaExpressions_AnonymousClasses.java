import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a person. The main point of this class is to demonstrate
 * the importance and usefulness of lambda expressions and anonymous classes.
 * 
 * @author Ian Fernandes
 *
 */
public class LambdaExpressions_AnonymousClasses implements Comparable<LambdaExpressions_AnonymousClasses> {

	/**
	 * Functional interface to be implemented by anonymous classes and lambda
	 * expressions located in main() method
	 * 
	 * @author Ian Fernandes
	 *
	 */
	public interface CheckPerson {
		boolean test(LambdaExpressions_AnonymousClasses p);
	}

	/**
	 * Constructor to initialize all instance variables (located below to
	 * demonstrate hoisting)
	 * 
	 * @param name
	 * @param email
	 * @param gender
	 * @param age
	 */
	public LambdaExpressions_AnonymousClasses(String name, String email, GenderEnums gender, int age) {
		this.name = name;
		emailAddress = email;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * Simple enum to give insight to how to declare an enum
	 *
	 */
	public enum GenderEnums {
		MALE, FEMALE
	}

	/**
	 * Instance variables to represent the name, email address, gender, and age of
	 * this person (LambdaExpressions_AnonymousClasses)
	 */
	private String name, emailAddress;
	private GenderEnums gender;
	private int age;

	/**
	 * compareTo() method to satisfy implementation of the Comparable interface
	 */
	public int compareTo(LambdaExpressions_AnonymousClasses b) {
		return name.compareTo(b.name);
	}

	/**
	 * Accessor method for age
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Method to print the name and email address of this person
	 * (LambdaExpressions_AnonymousClasses)
	 */
	public void printPerson() {
		System.out.println(name + ": " + emailAddress);
	}

	/**
	 * Accessor method for gender
	 * 
	 * @return
	 */
	public GenderEnums getGender() {
		return gender;
	}

	/**
	 * Prints all people (LambdaExpressions_AnonymousClasses) that satisfy the
	 * condition defined by the CheckPerson functional interface, which is defined
	 * by an anonymous class and lambda expression below in the main method.
	 * 
	 * @param roster ArrayList of people
	 * @param d      functional interface used in condition to select people to
	 *               print out
	 */
	public static void printPersonsOlderThan(List<LambdaExpressions_AnonymousClasses> roster, CheckPerson d) {
		for (LambdaExpressions_AnonymousClasses p : roster) {
			if (d.test(p))
				p.printPerson();
		}
	}

	/**
	 * Method to test above methods. Demonstration of Anonymous Classes and Lambda
	 * Expressions
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ArrayList to hold instances of class
		List<LambdaExpressions_AnonymousClasses> list = new ArrayList<>();

		// Testing enum
		GenderEnums a = GenderEnums.MALE;

		// Emails are not genuine
		list.add(new LambdaExpressions_AnonymousClasses("Ian", "ferns234@gmail.com", a, 16));
		list.add(new LambdaExpressions_AnonymousClasses("Chris", "cobiasIDK@gmail.com", a, 16));
		list.add(new LambdaExpressions_AnonymousClasses("Justin", "all254@gmail.com", a, 15));

		// Testing in-line definition of test() method (Anonymous Class)
		printPersonsOlderThan(list, new CheckPerson() {
			public boolean test(LambdaExpressions_AnonymousClasses d) {
				return d.getAge() >= 16;
			}
		});

		System.out.println();

		// Test lambda expression that has the same function as the anonymous class code
		printPersonsOlderThan(list, (LambdaExpressions_AnonymousClasses p) -> p.getAge() >= 16);

		System.out.println();

		// This time, we define the lambda expression and then use it in an expression.
		CheckPerson myLambdaExpression = (LambdaExpressions_AnonymousClasses p) -> {
			return p.getAge() >= 16;
		};

		printPersonsOlderThan(list, myLambdaExpression);

	}

}
