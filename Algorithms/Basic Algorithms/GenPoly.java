//---------------------------
// David Sabzanov
// Comp 110/110L Spring 2013
// GenPoly
//---------------------------

import java.util.*;
public class GenPoly {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		double x, y;
		
		String answer = "yes";
		while (answer.equals("yes")) {
			System.out.print("Degree of Polynomial? ");
			int degree = input.nextInt();
			double[] coeff = new double[degree+1];
			int i = 0;
			int j = degree; 
			while (i<=degree) {
				System.out.print("Enter Coefficient "+j+": ");
				coeff[j] = input.nextInt();
				j--;
				i++;
			}
		
			String answer2 = "yes";
			while (answer2.equals("yes")) {
				System.out.print("Enter x: ");
				x = input.nextDouble();
								
				y = coeff[degree];
				for (int z = degree-1; z>=0; z--) {
					y = y * x;
					y = y + coeff[z]; 
				}
				
				System.out.println("f(x) = " +y);
				
				System.out.print("Evaluate another value of x? ");
				answer2 = input.next();
				answer2 = answer2.toLowerCase();
			}
			System.out.print("Another polynomial? ");
			answer = input.next();
			answer = answer.toLowerCase();
		}
	}
}