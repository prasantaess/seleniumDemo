package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;

public class FindTheLongestString {
	
	@Test
	public void findTheLongestString() {
		
		List<String> strings = List.of("apple", "banana", "cherry", "grapefruit");
		
		Optional x = strings.stream().max((a,b)->a.length()-b.length());
		System.out.println("The longest String is "+x);
	}

}
