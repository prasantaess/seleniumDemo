package JavaPractice;

import java.util.stream.IntStream;

import org.testng.annotations.Test;

public class CheckPalindrome {
	
	@Test
	public void checkPalindrome() {
		
		String m = "madam";
		String r ="";
		for (int i = m.length()-1; i>=0; i--) {
			r=r+m.charAt(i);
		}
		System.out.println(r);
		if(m.equals(r)) {
			System.out.println("The Strings are Plindrome "+m+" : "+r);
		}else {
			System.out.println("The Strings are not Plindrome "+m+" : "+r);

		}
	}
	@Test
	public void checkPalindromethroughList() {
		
		String m="ROTATOR";
		String r = "";
		boolean isPalindron= IntStream.range(0, m.length()/2).noneMatch(i->m.charAt(i)!=m.charAt(m.length()-i-1));
		if(isPalindron==true) {
			System.out.println("The Strings are Plindrome ");
		}else {
			System.out.println("The Strings are not Plindrome ");

		}
		
	}

}
