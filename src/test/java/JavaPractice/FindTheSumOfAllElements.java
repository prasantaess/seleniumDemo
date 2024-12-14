package JavaPractice;

import java.util.*;

import org.testng.annotations.Test;

public class FindTheSumOfAllElements {
	
	@Test
	public void findtheSumOfAllElement() {
	
		List<Integer> ls = Arrays.asList(10,20,30,40,50,60,70,80,90);
	    int sum = ls.stream().reduce((a,b)-> a+b).get();
	    int sum2 = ls.stream().mapToInt(e->e).sum();
	    System.out.println(sum);
	    System.out.println(sum2);
	
	
	}

}
