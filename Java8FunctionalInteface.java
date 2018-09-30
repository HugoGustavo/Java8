import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8FunctionalInteface {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		//Predicate<Interger> predicate = n -> true
		// n is passed as parameter to test method Predicate interface
		// test method will always return true no matter what value n has.
		
		System.out.println("Print all numbers");
		
		// pass n as parameter
		eval(list, n -> true);
		
		// Predicate<Integer> predicate2 = n -> n > 3
		// n is passed as parameter to test method of Predicate Inteface
		// test method will return true if n is greater than 3.
		
		System.out.println("Print number greater than 3: ");
		eval(list, n -> n > 3 );

	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if ( predicate.test(n) )
				System.out.println(n + " ");
		}
	}

}
