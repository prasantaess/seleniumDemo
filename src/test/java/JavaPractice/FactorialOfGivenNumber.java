package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.IntStream;

public class FactorialOfGivenNumber {
	
	@Test
	public void factorialOfGivenNumber() {
		
		int givenNumber=6;
		int d = IntStream.rangeClosed(1, givenNumber).reduce(1,(a,b)->a*b);
		System.out.println("Factorial of the given number "+d);
	}

}
