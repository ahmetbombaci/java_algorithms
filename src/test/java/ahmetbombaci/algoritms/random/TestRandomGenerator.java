package ahmetbombaci.algoritms.random;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import ahmetbombaci.algoritms.random.RandomGenerator;

public class TestRandomGenerator {

	@Test
	public void testRange() {
		RandomGenerator r = new RandomGenerator();
		int random = r.rand5();
		
		assertTrue(random>=0 && random<5);
	}
	
	@Test
	public void testDistribution() {
		RandomGenerator r = new RandomGenerator();
		int[] count = new int[5];
		
		for(int i =0; i<1000000; i++)
		{
			count[r.rand5()]++;
		}
		
		Arrays.stream(count).forEach(t -> 
		{
			System.out.println(t);
			assertTrue(t > 198000 && t < 202000);
		});
		
	}
}
