/*
Programmer: David Sabzanov
Project#: 9
Due Date: Thursday, November 1, 2012
Class: Comp 108 9:30-10:45
Description: This program generates
a random number between 10 and 100
and determines how many are odd and
how many are even. 
*/

public class RandomWhile
{
	public static void main(String []args)
	{
	int i = 1;
	int evenNum = 0;
	int oddNum = 0;
	while (i <= 10) {
		int num = (int)(Math.random()*90)+10;
		boolean even=num%2==0;
		if (even==true) {
			System.out.println(num);
			evenNum++;
			}
		else {
			System.out.println(num);
			oddNum++;
			}
		i++;
		}
	System.out.println("There are "+oddNum+" odd numbers and there are "+evenNum+" even numbers.");
	}
}