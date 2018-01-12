/*
Programmer: David Sabzanov
Project#: 5
Due Date: Thursday, October 11, 2012
Class: Comp108 9:30-10:45
Description: This program computes the gross pay.
*/

import java.util.Scanner;
public class Grosspay
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
				 
		double payRate, grossPay, hours;
		
		System.out.print("Enter Employee name: ");
		String employee=input.nextLine();
		System.out.print("Enter hours worked: ");
		hours=input.nextInt();
		System.out.print("Enter pay rate: ");
		payRate=input.nextInt();
		System.out.println();
		
		if (hours<=40) {
			grossPay=payRate*hours;
		}
		else if (hours<=54) {
			grossPay=40*payRate+1.5*payRate*(hours-40);
		}			
		
		else {
			grossPay=(40*payRate)+(1.5*payRate*(54-40))+(2*payRate*(hours-54));
		}
		
		//System.out.print(employee+" worked for "+hours+" hours with pay rate of $"+payRate+". The gross pay for "+employee+" is $"+grossPay+".");
		System.out.printf(employee+"%-12s"+hours+"%-25s"+payRate+"%-20s"+employee+"%-5s%-1f%-1s"," worked for "," hours with pay rate of $",". The gross pay for "," is $",grossPay,".");
	}
}