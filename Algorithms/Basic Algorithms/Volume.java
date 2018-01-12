/*
Programmer: David Sabzanov
Project#: 4
Due Date: Thursday, October 3, 2012
Class: Comp108 9:30-10:45

Description: Finding the volume of a cylinder.
*/

import java.util.Scanner;
public class Volume
{
    public static void main(String args[]) 
    {
        Scanner input=new Scanner(System.in);
        double area, radius, volume, length;
        System.out.println("Enter radius and length of the cylinder: ");
        radius=input.nextDouble(); length=input.nextDouble();
        //System.out.println("Enter the length of the cylinder:");
        // length=input.nextDouble();
        
		  area=radius*radius*Math.PI;
        volume=area*length;
		  
        System.out.println("The area is: "+area);
        System.out.println("The volume of the cylinder is: "+volume);
    } 
}