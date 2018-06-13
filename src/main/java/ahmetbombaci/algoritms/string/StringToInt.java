package ahmetbombaci.algoritms.string;

public class StringToInt {

	private static final int MAX_THRESHOLD = Integer.MAX_VALUE / 10; 
	private static final int MIN_THRESHOLD = Integer.MIN_VALUE / 10;
	
	class Overflow {
		int result;
		boolean indicator;
		
		public Overflow() {
			result = 0;
			indicator = false;
		}
	}
	
	private void calculate(Overflow currentTotal, int nextDigit, short sign) {
		if(sign>0) {
			if(currentTotal.result > MAX_THRESHOLD) {
				currentTotal.result = Integer.MAX_VALUE;
				currentTotal.indicator = true;
				return;
			}
			
			currentTotal.result = currentTotal.result * 10 + nextDigit;
			
			if(currentTotal.result < 0) {
				currentTotal.result = Integer.MAX_VALUE;
				currentTotal.indicator = true;
			}
		}
		else {
			if(currentTotal.result < MIN_THRESHOLD) {
				currentTotal.result = Integer.MIN_VALUE;
				currentTotal.indicator = true;
				return;
			}
			
			currentTotal.result = currentTotal.result * 10 - nextDigit;
			
			if(currentTotal.result > 0) {
				currentTotal.result = Integer.MIN_VALUE;
				currentTotal.indicator = true;
			}
		}
	}
	
	
    public int myAtoi(String str) {
    	
    	char[] ch = str.toCharArray();
    	
    	//skip leading spaces
    	int i=0;
    	for(; i<ch.length; i++) {
    		if(ch[i] != ' ')
    			break;
    	}
    	
    	//check optional sign    	
    	short sign = 1;
    	if(i<ch.length) {
	    	if(ch[i] == '+')
	    		i++;
	    	else if(ch[i]=='-') {
	    		i++;
	    		sign = -1;
	    	}
    	}
    	
    	//scan digits
    	Overflow result = new Overflow();
    	
    	//int total = 0;

    	for(; i<ch.length; i++) {
    		if(ch[i] < '0' || ch[i] > '9')
    			break;

    		int number = ch[i]-'0';
    		
    		calculate(result, number, sign);
    		
    		if(result.indicator)
    			return result.result;
    	}
    	
        return result.result;
    }

	public static void main(String[] args) {
		StringToInt exec = new StringToInt();

		System.out.println(exec.myAtoi("  -6147483648"));
		
		
		
	}
}
