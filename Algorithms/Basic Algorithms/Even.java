/*
Programmer: David Sabzanov
Project#: 5
Due date: Thursday, October 11, 2012
Class: Comp108 9:30-10:45
Description: This program checks whether an integer is even or not.
*/

import java.util.Scanner;
public class Even
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		int integer;
		System.out.print("Enter an integer: ");
		integer=input.nextInt();
		System.out.print("Is "+integer+" an even number? ");
		boolean even=integer%2==0;
		if (even==true){
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
}