package ahmetbombaci.algoritms.string;

import java.util.Arrays;

public class Palindrome {

	private static final int SIZE = 'z' - 'a';
	
	//Write an efficient method that checks whether any permutation ↴ of an input string is a palindrome. 
	//You can assume the input string only contains lowercase letters.
	/*
	 * "civic" should return true
	 * "ivicc" should return true
	 * "civil" should return false
	 * "livci" should return false
	 */
	public static boolean hasPermutationPalindrome(String input) {
		int[] count = new int[SIZE];
		
		for(char c : input.toCharArray()) {
			count[arrayIndex(c)]++;
		}
		
		long oddCount = Arrays.stream(count).filter(t -> t%2==1).count();
		
		return oddCount < 2l;
	}
	
	private static int arrayIndex(char c) {
		return c - 'a';
	}
	
	public static void main(String[] args) {
		boolean b = Palindrome.hasPermutationPalindrome("livci");
		System.out.println(b);
	}
}
