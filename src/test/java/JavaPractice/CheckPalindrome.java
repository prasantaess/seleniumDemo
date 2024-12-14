package JavaPractice;

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

}
