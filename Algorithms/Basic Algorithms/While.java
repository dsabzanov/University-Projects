 /*
Programmer: David Sabzanov
Project#: 8
Class: Comp 108 9:30-10:45
Date: Tuesday, October 30, 2012
Description: While loop with miles and kilometers.
*/

public class While
{
	public static void main(String []args)
	{
		double sum = 0;
		int i = 1;
		
		System.out.printf("%-5s%15s\n", "Miles","Kilometers");
		while (i <=10) {
			double kilometers = i*1.609;
			System.out.printf("%-5s%15.3f\n", i,kilometers);
			i++;
		}
	}
}