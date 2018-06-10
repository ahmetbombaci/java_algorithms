package ahmetbombaci.algoritms.random;

import java.util.Random;

public class RandomGenerator {
	
	/*
	 * You have a function rand7() that generates a random integer from 1 to 7. Use it to write a function rand5() that generates a random integer from 1 to 5.
	 * rand7() returns each integer with equal probability. rand5() must also return each integer with equal probability.
	 */
	private Random random = new Random();
	
	private int rand7() {
		return random.nextInt(7);
	}
	
	public int rand5() {
		return (rand7() + rand7() + rand7() + rand7() + rand7()) % 5;
	}
}
