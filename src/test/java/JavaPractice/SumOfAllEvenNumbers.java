package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SumOfAllEvenNumbers {
	
	
	@Test
	
	public void SumOfAllEvenNumbers() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int Sum = numbers.stream().filter(e-> e%2==0).mapToInt(e-> Integer.valueOf(e)).sum();
		System.out.println("The Sum of the number is  "+Sum);
	}

}
