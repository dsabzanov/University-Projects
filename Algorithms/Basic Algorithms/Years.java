/*
Programmer: David Sabzanov
Project#: 4
Due Date: Thursday, October 3, 2012
Class: Comp108 9:30-10:45

Description: Finding the number of years and days from minutes.
*/

import java.util.Scanner;
public class Years
{
    public static void main(String args[]) 
    {
        Scanner input=new Scanner(System.in);
		  int minutes, days, years;
		  System.out.print("Enter the number of minutes: ");
		  minutes=input.nextInt();
		  
		  years=minutes/525600;
		  minutes=minutes%525600;
		  days=minutes/1440;
		System.out.println(+minutes+" minutes is approximately "+years+" years and "+days+" days."); 
	}
}