package Lab02;

public class AddTwoMatrices {

	public static void main(String[] args) {
		int a[][]={{1,3,5},{2,4,6},{1,5,4}};    
		int b[][]={{1,3,5},{2,4,6},{2,3,7}};    
		
		int c[][]=new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}
