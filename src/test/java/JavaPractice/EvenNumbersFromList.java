package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Collectors;

public class EvenNumbersFromList {
	
	@Test
	
	public void evenNumbersFromList() {
		
		  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		  List<Integer> even = numbers.stream().filter(e->e%2==0).collect(Collectors.toList());
		  List<Integer> odd = numbers.stream().filter(e->e%2!=0).collect(Collectors.toList());
		  System.out.println(even);
		  System.out.println(odd);
		
	}

}
