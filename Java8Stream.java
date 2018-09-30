import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Stream {
	public static void generateStreamExample() {
		System.out.println("\n\nGenerate Stream");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		filtered.forEach(System.out::println);
	}
	
	public static void forEachExample() {
		System.out.println("\n\nForEach");
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}
	
	public static void mapExample() {
		System.out.println("\n\nMap");
		List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
		List<Integer> squaresList = numbers.stream().map(i -> i *i).distinct().collect(Collectors.toList());
		squaresList.forEach(System.out::println);
	}
	
	public static void filterExample() {
		System.out.println("\n\nFilter");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println(strings.stream().filter(string -> string.isEmpty()).count());
	}
	
	public static void limitExample() {
		System.out.println("\n\nLimit");
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}
	
	public static void sortExample() {
		System.out.println("\n\nSorted");
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
	}
	
	public static void parallelProcessingExample() {
		System.out.println("\n\nParallel Processing");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println(strings.parallelStream().filter(string -> string.isEmpty()).count());
		
	}
	
	public static void collectorsExample() {
		System.out.println("\n\nCollectors");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		
		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged Sorted: " + mergedString);
	}
	
	public static void statisticsExample() {
		System.out.println("\n\nStatistics");
		List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
		IntSummaryStatistics stats = numbers.parallelStream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Highest number in List: " + stats.getMax());
		System.out.println("Lowest number in List: " + stats.getMin());
		System.out.println("Sum of all numbers: " + stats.getSum());
		System.out.println("Average of all numbers: " + stats.getAverage());
	}
	
	public static int getCountEmptyStringUsingJava7(List<String> strings) {
		int count = 0;
		for (String string : strings) {
			if ( string.isEmpty() ) {
				count++;
			}
		}
		return count;
	}
	
	public static int getCountLegth3UsingJava7(List<String> strings) {
		int count = 0;
		for (String string : strings)
			if (string.length() == 3)
				count++;

		return count;
	}
	
	public static List<String> deleteEmptyStringUsingJava7(List<String> strings){
		List<String> filteredList = new ArrayList<String>();
		for (String string : strings) {
			if (!string.isEmpty()) {
				filteredList.add(string);
			}
		}
		return filteredList;
	}
	
	public static String getMergedStringUsingJava7(List<String> strings, String separator) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			if (!string.isEmpty()) {
				stringBuilder.append(string);
				stringBuilder.append(separator);
			}
		}
		String mergedString = stringBuilder.toString();
		return mergedString.substring(0, mergedString.length()-2);
	}
	
	public static List<Integer> getSquares(List<Integer> numbers){
		List<Integer> squaresList = new ArrayList<Integer>();
		
		for (Integer number : numbers) {
			Integer square = new Integer(number.intValue() * number.intValue());
			if (!squaresList.contains(square)) {
				squaresList.add(square);
			}
		}
		
		return squaresList;
		
	}
	
	public static int getMax(List<Integer> numbers) {
		int max = numbers.get(0);
		
		for (int i = 1; i < numbers.size(); i++) {
			Integer number = numbers.get(i);
			if (number.intValue() > max) {
				max = number.intValue();
			}
		}
		
		return max;
	}
	
	public static int getMin(List<Integer> numbers) {
		int min = numbers.get(0);
		
		for (int i = 1; i < numbers.size(); i ++) {
			Integer number = numbers.get(i);
			
			if ( number.intValue() < min ) {
				min = number.intValue();
			}
		}
		
		return min;
	}
	
	public static int getSum(List<Integer> numbers) {
		int sum = (int)(numbers.get(0));
		for (int i =1; i < numbers.size(); i++) {
			sum += (int) numbers.get(i);
		}
		return sum;
	}
	
	public static int getAverage(List<Integer> numbers) {
		return getSum(numbers) / numbers.size();
	}
	public static void main(String[] args) {
		System.out.println("Using Java 7: ");
		
		//Count empty strings
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println("List: " + strings);
		long count = getCountEmptyStringUsingJava7(strings);
		System.out.println("Empty Strings: " + count);
		
		count = getCountLegth3UsingJava7(strings);
		System.out.println("Strings of length 3: " + count);
		
		//Eliminate empty string
		List<String> filtered = deleteEmptyStringUsingJava7(strings);
		System.out.println("Filtered List: " + filtered);
		
		//Eliminate empty string and joint using comma.
		String mergedString = getMergedStringUsingJava7(strings, ", ");
		System.out.println("Merged String: " + mergedString);
		List<Integer> numbers = Arrays.asList(3,2,3,7,3,5);
		
		// get list square of distinct numbers
		List<Integer> squaresList = getSquares(numbers);
		System.out.println("Squares List: " + squaresList);
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		
		System.out.println("List: " + integers);
		System.out.println("Highest number in list: " + getMax(integers));
		System.out.println("Lowest number in List: " + getMin(integers));
		System.out.println("Sum of all numbers: " + getSum(integers));
		System.out.println("Average of all numbers: " + getAverage(integers));
		System.out.println("Random numbers: ");
		
		//print ten random numbers
		Random random = new Random();
		for (int i = 0; i < 10; i++)
			System.out.println(random.nextInt());
		
		System.out.println("\n\n");
		
		System.out.println("Using Java 8");
		System.out.println("List: " + strings);
		
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);
		
		count = strings.parallelStream().filter(string -> string.length() == 3).count();
		System.out.println("Strings of length 3: " + count);
		
		filtered = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);
		
		mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		squaresList = numbers.parallelStream().map(i -> (i*i)).distinct().collect(Collectors.toList());
		System.out.println("Squares List: " + squaresList);
		System.out.println("List: " + integers);
		
		IntSummaryStatistics stats = integers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Highest number in List: " + stats.getMax());
		System.out.println("Lowest number in List: " + stats.getMin());
		System.out.println("Sum of all numbers: " + stats.getSum());
		System.out.println("Average of all numbers: " + stats.getAverage());
		System.out.println("Random Numbers: ");
		
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		//parallel processing
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);
		
	}

}