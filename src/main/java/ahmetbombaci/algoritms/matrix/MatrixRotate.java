package ahmetbombaci.algoritms.matrix;

public class MatrixRotate {
	
	private byte[][][] squareImage;
	private int dimension;
	private int pixelSize;
	
	public MatrixRotate(byte[][][] picture,int dimension, int pixelSize) {
		this.pixelSize = pixelSize;
		this.dimension = dimension;
		
		this.squareImage = new byte[dimension][dimension][pixelSize];
		this.copy(picture);
	}
	
	private void copy(byte[][][] picture) {
		for(int i=0; i< dimension; i++) {
			for(int j=0; j<dimension; j++) {
				for(int k=0; k< pixelSize; k++) {
					this.squareImage[i][j][k] = picture[i][j][k];
				}
			}
		}
		
	}
	
	private byte[] getCopyOfPixel(int row, int col) {
		byte[] copyOfPixel = new byte[this.pixelSize];
		
		for(int i=0; i<this.pixelSize; i++) {
			copyOfPixel[i] = this.squareImage[row][col][i];
		}
		return copyOfPixel;
	}

	public void display() {
		System.out.println(this.toString() ); 
	}
	
	public byte[][][] getImage() {
		return this.squareImage;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< dimension; i++) {
			sb.append("[ row(" + i + "): \n");
			for(int j=0; j<dimension; j++) {
				sb.append("   [ column(" + j + "): ");
				for(int k=0; k< pixelSize; k++) {
					sb.append(this.squareImage[i][j][k] + " ");
				}
				sb.append("]\n");
			}
			sb.append("]\n");
		}
		
		return sb.toString();
	}
	
	
	public void rotate() {
		int border = (int) Math.ceil(dimension/2);
		
		for(int i=0; i< border; i++) {
			for(int j=0; j<border; j++) {
				byte[] temp = this.getCopyOfPixel(i, j);
				
				this.squareImage[i][j] = this.squareImage[dimension-j-1][i];
				this.squareImage[dimension-j-1][i] = this.squareImage[dimension-i-1][dimension-j-1];
				this.squareImage[dimension-i-1][dimension-j-1] =this.squareImage[j][dimension-i-1];
				this.squareImage[j][dimension-i-1] = temp;				
			}
		}		
	}

	public static void main(String[] args) {
		byte[][][] imageByte = new byte[4][4][4];
		byte counter = 0;
		for(int i=0; i< 4; i++) {
			for(int j=0; j<4; j++) {
				counter++;
				for(int k=0; k< 4; k++) {
					imageByte[i][j][k] = counter;
				}
			}
		}
		MatrixRotate image = new MatrixRotate(imageByte, 4, 4);
		
		image.display();
		
		image.rotate();
		
		image.display();
		
			
	}


}
