package ahmetbombaci.algoritms.matrix;

import static org.junit.Assert.assertArrayEquals;

import java.util.Random;

import org.junit.Test;

public class TestMatrixRotate {
	
	@Test
	public void testRandom() {
		Random rand = new Random();
		int dimension = rand.nextInt(10) + 1;
		int pixel = rand.nextInt(10) + 1;
		byte[][][] imageByte = new byte[dimension][dimension][pixel];
		

		for(int i=0; i< dimension; i++) {
			for(int j=0; j<dimension; j++) {
				rand.nextBytes(imageByte[i][j]);
			}
		}
		
		
		
		MatrixRotate m = new MatrixRotate(imageByte, dimension, pixel);
		
		m.display();
		
		m.rotate();
		System.out.println("1st rotate");
		m.display();
		
		m.rotate();
		System.out.println("2nd rotate");
		m.display();
		
		m.rotate();
		System.out.println("3rd rotate");
		m.display();
		
		m.rotate();
		System.out.println("4th rotate");
		m.display();
		
		assertArrayEquals(imageByte, m.getImage());
	}

}
