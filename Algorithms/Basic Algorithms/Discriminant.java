/*
Programmer: David Sabzanov
Project#: 6
Due Date: Tuesday, October 16, 2012
Class: Comp108 9:30-10:45
Description: Finding the number of roots of 
a quadratic equation using the discriminant
and displaying the roots in the output.
*/
import java.util.*;
public class Discriminant
{
	public static void main(String []args)
	{
		Scanner input=new Scanner(System.in);
		
		double a, b, c;
		
		System.out.print("Enter a, b, c: ");
		a=input.nextDouble(); b=input.nextDouble(); c=input.nextDouble();
		
		double 
		discriminant=Math.pow(b,2)-4*a*c,
		root1=(-b+(Math.sqrt(discriminant)))/(2*a),
		root2=(-b-(Math.sqrt(discriminant)))/(2*a);
		
		if (discriminant > 0) {
			System.out.printf("The roots are %2.6f and %2.5f",root1, root2);
		}
		else if (discriminant == 0) {
			System.out.printf("The root is: "+root1);
		}
		else {
			System.out.print("The equation has no real roots.");
		}	
	}
}