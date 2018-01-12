/*
Programmer: David Sabzanov
Project#: 6
Due Date: Tuesday, October 16, 2012
Class: Comp108 9:30-10:45
Description: This program calculates and prints the monthly paycheck for an employee.
*/

import java.util.Scanner;
public class Netpay
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		
		double 
		grossPay, 
		fedTax, 
		stateTax, 
		ssTax, 
		mediTax, 
		pensionPlan, 
		healthInsurance, 
		netPay;
		
		final double 
		FED_TAX_RATE=0.15, 
		STATE_TAX_RATE=0.035, 
		SOCIAL_SECURITY_TAX_RATE= 0.0575, 
		MEDI_TAX_RATE= 0.0275,
		PENSION_PLAN=0.05, 
		HEALTH_INSURANCE=75.00;
		
		System.out.print("Enter employee name: ");
		String employee=input.nextLine();
		System.out.print("Enter employee gross pay: ");
		grossPay=input.nextDouble();
		System.out.println();
		
		fedTax=grossPay*FED_TAX_RATE;
		stateTax=grossPay*STATE_TAX_RATE;
		ssTax=grossPay*SOCIAL_SECURITY_TAX_RATE;
		mediTax=grossPay*MEDI_TAX_RATE;
		pensionPlan=grossPay*PENSION_PLAN;
		healthInsurance=HEALTH_INSURANCE;
		
		netPay=grossPay-(fedTax+stateTax+ssTax+mediTax+pensionPlan+healthInsurance);
		
		System.out.printf("%-24s\n",employee);
		System.out.printf("%-24s$%8.2f\n","Gross Amount:",grossPay);
		System.out.printf("%-24s$%8.2f\n","Federal Tax:",fedTax);
		System.out.printf("%-24s$%8.2f\n","State Tax:",stateTax);
		System.out.printf("%-24s$%8.2f\n","Social Security Tax:",ssTax);
		System.out.printf("%-24s$%8.2f\n","Medicare/Medicaid Tax:",mediTax);
		System.out.printf("%-24s$%8.2f\n","Pension Plan:",pensionPlan);
		System.out.printf("%-24s$%8.2f\n","Health Insurance:",healthInsurance);
		System.out.printf("%-24s$%8.2f\n","Net Pay:",netPay);
	}
}