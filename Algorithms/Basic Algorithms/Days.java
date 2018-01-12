/*
Programmer: David Sabzanov
Project#: 7
Due Date: Thursday, October 18, 2012
Class: Comp108 9:30-10:45
Description: This program finds the number of days in month.
*/

import java.util.*;
public class Days
{
	public static void main(String []args)
	{
		Scanner input=new Scanner(System.in);
		
		int days, month, year;
		
		System.out.print("Enter a month as a number ranging from 1 to 12: ");
		month=input.nextInt();
		System.out.print("Enter year: ");
		year=input.nextInt();
		
		switch (month) {
			case 1: System.out.print("January "+year+" had 31 days."); break;
			case 2: if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {
							System.out.print("February "+year+" had 29 days.");
					  }
					  else { 
					  		System.out.print("February "+year+" had 28 days.");
					  }
					  break;
			case 3: System.out.print("March "+year+" had 31 days."); break;
			case 4: System.out.print("April "+year+" had 30 days."); break;
			case 5: System.out.print("May "+year+" had 31 days."); break;
			case 6: System.out.print("June "+year+" had 30 days."); break;
			case 7: System.out.print("July "+year+" had 31 days."); break;
			case 8: System.out.print("August "+year+" had 31 days."); break;
			case 9: System.out.print("September "+year+" had 30 days."); break;
			case 10: System.out.print("October "+year+" had 31 days."); break;
			case 11: System.out.print("November "+year+" had 30 days."); break;
			case 12: System.out.print("December "+year+" had 31 days."); break;
		}				
	}
}