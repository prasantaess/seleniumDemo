package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Stream;

public class SortTheStringBasedOnTheLength {
	
	@Test
	public void sortTheStringBasedOnTheLength() {
		
		List<String> strings = List.of("apple", "banana", "cherry", "grapefruit");
		
		Stream<String> x = strings.stream().sorted((a,b)->a.length()-b.length());
		System.out.println("The longest String is "+x.toString());
	}
	
	@Test
	public void sortTheStringBasedOnTheLength2() {
		
		List<String> strings = Arrays.asList("grapefruit","apple","banana", "cherry");
		
		Collections.sort(strings, Comparator.comparingLong(String :: length));
		System.out.println(strings);
		
		
		
	}

}
