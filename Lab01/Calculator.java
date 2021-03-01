import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter 1st number: ");
		double num1 = scanner.nextDouble();
		System.out.print("Enter 2nd number: ");
		double num2 = scanner.nextDouble();
		System.out.println("===================");
		double sum = num1+num2;
		System.out.println("Sum: "+sum);
		
		double diff = num1-num2;
		System.out.println("Difference: "+diff);
		
		double product = num1*num2;
		System.out.println("Product: "+product);
		
		if (num2==0) {
			System.out.println("Divisor is 0. Can't divide");
		}else {
			double quotient = num1/num2;
			System.out.println("Quotient: "+quotient);
		}
		scanner.close();
	}
}
