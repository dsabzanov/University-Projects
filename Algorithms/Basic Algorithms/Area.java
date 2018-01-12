/*
Programmer: David Sabzanov
Project#: 3
Due Date: Thursday, September 27, 2012
Class: Comp108 9:30-10:45

Description:
This program computes the time required (in minutes) to cut the 
grass of a yard at the rate of 2.3 square meters a second with the 
lengths and widths of both the yard and the house situated 
in the yard, given by the user.
*/

import java.util.Scanner;
public class Area
{
	public static void main(String[] args)
	{
	Scanner input=new Scanner(System.in);
	
	double rate = 2.3, yardLength, yardWidth, houseLength, 
	houseWidth, yardArea, houseArea, grassArea, cuttingTime;
	
	System.out.println("Enter Yard Length");
	yardLength=input.nextDouble();
	System.out.println("Enter Yard Width");
	yardWidth=input.nextDouble();
	System.out.println("Enter House Length");
	houseLength=input.nextDouble();
	System.out.println("Enter House Width");
	houseWidth=input.nextDouble();
	
	yardArea = yardLength * yardWidth;
	houseArea = houseLength * houseWidth;
	grassArea = yardArea - houseArea;
	cuttingTime = grassArea/rate/60;
	
	System.out.println("The time to cut the grass is "+cuttingTime+" minutes.");
	System.out.println();
	System.out.println("Yard Length is "+yardLength+" meters.");
	System.out.println("Yard Width is "+yardWidth+" meters.");
	System.out.println("Yard Area is "+yardArea+" square meters.");
	System.out.println("House Length is "+houseLength+" meters.");
	System.out.println("House Width is "+houseWidth+" meters.");
	System.out.println("House Area is "+houseArea+" square meters.");
	System.out.println("Grass Area is "+grassArea+" square meters.");
	System.out.println("Cutting Time is "+cuttingTime+" minutes.");
	}
}