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
	
	public int maxOneSequenceWithFlip(int input)
	{
		int num = input;
		int prevCount=0;
		int currCount=0;
		boolean firstZero = true;
		int max=0;
		while(num!=0)
		{
			if((num & 1) == 1)
			{
				firstZero = true;
				currCount++;
			}
			else
			{
				if(firstZero) {
					int localMax= prevCount + 1 + currCount;
					max = Math.max(max,  localMax);
					prevCount = currCount;
					currCount = 0;
					firstZero = false;
				}
				else {
					prevCount = 0;
				}
			}
			
			num = num >>> 1;
		}
		
		int extraBit=0;
		if(input<0) {
			extraBit = (prevCount==0 ? 0 : 1 );
		}
		else {
			extraBit = 1;
		}
		
		int localMax= prevCount + extraBit + currCount;
		max = Math.max(max,  localMax);
		
		return max;
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
		
		// bits.displayBits(0.125);

		System.out.println(bits.maxOneSequenceWithFlip(-1));
		System.out.println(bits.maxOneSequenceWithFlip(0));
		System.out.println(bits.maxOneSequenceWithFlip(1));
		System.out.println(bits.maxOneSequenceWithFlip(2));
		System.out.println(bits.maxOneSequenceWithFlip(3));
		System.out.println(bits.maxOneSequenceWithFlip(4));
		System.out.println(bits.maxOneSequenceWithFlip(5));
		System.out.println(bits.maxOneSequenceWithFlip(6));
		System.out.println(bits.maxOneSequenceWithFlip(7));
		System.out.println(bits.maxOneSequenceWithFlip(8));
		System.out.println(bits.maxOneSequenceWithFlip(1775));
		
		
		
	}
}
