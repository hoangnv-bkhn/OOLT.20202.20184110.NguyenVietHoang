import java.util.Scanner;

public class Solve_Equation {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int option;
		do {
		System.out.println("\n==========Menu==========");
		System.out.println("1. Solve a first-degree equation (linear equation) with one variable.");
		System.out.println("2. Solve a system first-degree equation (linear equation) with two variables.");
		System.out.println("3. Solve a second-degree equation with one variable.");
		System.out.println("4. Exit.");
		System.out.print("Your choice is: ");
		option = scanner.nextInt();
		
		switch (option) {
		case 1:
			double a, b;
			do {
			System.out.print("Enter a (not equal to zero): ");
			a = scanner.nextDouble();
			if (a==0) {
				System.out.println("a can't equal to zero. Please enter a's value again.");
			}
			}while(a==0);
			System.out.print("Enter b: ");
			b = scanner.nextDouble();
			System.out.println("Your equation is:"+a+"*x + "+b+" = 0");
			double x = -b/a;
			System.out.println("Solution: x = "+x);
			break;
		case 2:
			System.out.println("a*x + b*y = c");
			System.out.println("m*x + n*y = p");
			System.out.println("Enter coefficients for the first equation:");
			double[] e1 = new double[3];
			for (int i = 0; i < 3; i++) {
				e1[i] = scanner.nextDouble();
			}
			System.out.println("Enter coefficients for the second equation:");
			double[] e2 = new double[3];
			for (int i = 0; i < 3; i++) {
				e2[i] = scanner.nextDouble();
			}
			double d = e1[0]*e2[1] - e2[0]*e1[1];
			double d1 = e1[2]*e2[1] - e2[2]*e1[1];
			double d2 = e1[0]*e2[2] - e2[0]*e1[2];
			if (d == 0) {
				if (d1 == 0 && d2 == 0) {
					System.out.println("The system has infinitely many solutions.");
				}else {
					System.out.println("The system has no solution.");
				}
			}else {
				double x1 = d1/d;
				double x2 = d2/d;
				System.out.println("The system has a unique solution (x,y) = ("+x1+","+x2+")");
			}
		case 3:
			System.out.println("Please enter coefficients for the equation");
			double A, B, C;
			do {
			System.out.print("Enter A (not equal to zero): ");
			A = scanner.nextDouble();
			if (A==0) {
				System.out.println("A can't equal to zero. Please enter A's value again.");
			}
			}while(A==0);
			System.out.print("Enter B: ");
			B = scanner.nextDouble();
			System.out.print("Enter C: ");
			C = scanner.nextDouble();
			System.out.println("Your equation is: "+A+"*x^2 + "+B+"*x + "+C+" = 0");
			double delta = B*B - 4*A*C;
			if (delta == 0) {
				System.out.println("The equation has double root: "+(-B/(2*A)));
			}else if (delta > 0) {
				double m1 = (-B+Math.sqrt(delta))/(2*A);
				double m2 = (-B-Math.sqrt(delta))/(2*A);
				
				System.out.println("The equation has two distinct roots: "+m1+" "+m2);
			}else {
				System.out.println("The equation has no solution");
			}
		default:
			break;
		}
		}while(option ==1 || option == 2 || option == 3);
		scanner.close();
	}
}
