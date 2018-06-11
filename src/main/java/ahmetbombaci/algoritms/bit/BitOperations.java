package ahmetbombaci.algoritms.bit;

public class BitOperations {

	public int insert(int N, int M, int i, int j)
	{
		//clear bits from i to j for N
		int mask = 1 << (j-i+2);
		mask--;
		mask >>= i;
		N &= ~mask;
		
		//shift M to i(th) position
		M <<= i;
		
		return M | N;
	}
	
	public void displayBits(int num) {
		StringBuilder sb = new StringBuilder();
		
		while(num!=0) {
			sb.insert(0, num%2);
			num >>= 1;
		}
		
		System.out.println(sb);
	}
	
	public void displayBits(double num) {
		if(num<0 || num>1) {
			System.out.println("ERROR");
		}
		else {
			StringBuilder sb = new StringBuilder();
			
			for(int i=1; i<=32; i++) {
				double check = 1 / Math.pow(2, i);
				sb.append((num>=check)?"1":"0");
				if(num>=check)
					num -= check;
			}
			if(num>0) {
				System.out.println("ERROR");
			}
			else {
				System.out.println(sb);
			}	
		}
	}
	
	public static void main(String[] args) 
	{
		BitOperations bits = new BitOperations();
		
		/*
		int N = 1 << 10;
		int M = 19;
		int i=2;
		int j=6;
		bits.displayBits(N);
		bits.displayBits(M);
		int result = bits.insert(N, M, i, j);
		System.out.println(result);
		bits.displayBits(result);
		*/
		
		bits.displayBits(0.125);
		
	}
}
