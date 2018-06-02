package ahmetbombaci.algoritms.string;

public class StringCompression {

	public String compress(String input)
	{	
		StringBuilder sb = new StringBuilder();
	
		int counter = 0;
		
		for(int i=0; i<input.length(); i++) {
			counter++;
			
			if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)) {
				sb.append(input.charAt(i));
				sb.append(counter);
				counter = 0;
			}
		}
		
		return sb.length() < input.length() ? sb.toString() : input;
	}
		
	public static void main(String[] args) {
		StringCompression compressor = new StringCompression();
		
		System.out.println("aabcccccaaa =>>" + compressor.compress("aabcccccaaa"));
		System.out.println(" =>>" + compressor.compress(""));
		System.out.println("a =>>" + compressor.compress("a"));
		System.out.println("abcd =>>" + compressor.compress("abcd"));
		
	}
}
