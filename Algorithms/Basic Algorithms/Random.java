/*
Programmer: David Sabzanov
Project#: 7
Due Date: Thursday, October 18, 2012
Class: Comp108 9:30-10:45
Description: This program displays a random
uppercase letter using the Math.random()
method.
*/

import java.util.*;
public class Random
{
	public static void main(String []args)
	{
		char randomUppercaseLetter;
		randomUppercaseLetter=(char)((int)'A'+Math.random()*((int)'Z'-(int)'A'+1));
		System.out.print("The random uppercase letter is: "+randomUppercaseLetter);
	}
}