/* 
Programmer: David Sabzanov
Project#: 10
Due Date: Tuesday, November 6, 2012
Class: Comp 108 9:30-10:45
Description: This program displays
the amortization schedule for a loan
by inputing the loan amount, number
of years and the annual interest
rate.
*/
import java.util.*;
public class Amortization
{
	public static void main(String []args)
	{
		Scanner input=new Scanner(System.in);
		
		int years;
		double annualInterestRate, loanAmount, principal, monthlyPay, monthlyInterestRate, totalPay;
		double balance=0;
		double monthlyInterest=0;
		
		System.out.print("Enter Loan Amount: ");
		loanAmount=input.nextInt();
		System.out.print("Enter Number of Years: ");
		years=input.nextInt();
		System.out.print("Enter Annual Interest Rate: ");
		annualInterestRate=input.nextDouble();
		System.out.println();
		
		System.out.println("Loan Amount: $"+loanAmount);
		System.out.println("Number of Years: "+years);
		System.out.println("Annual Interest Rate: "+annualInterestRate);
		System.out.println();
		
		monthlyInterestRate=annualInterestRate/1200;
		monthlyPay=loanAmount*monthlyInterestRate/(1-1/Math.pow(1+monthlyInterestRate, years*12));
		totalPay=monthlyPay*years*12;
		
		System.out.printf("%-17s%1s%6.2f\n","Monthly Payment: ","$",monthlyPay);
		System.out.printf("%-15s%1s%8.2f\n","Total Payment: ","$",totalPay);
		System.out.println();
		
		System.out.printf("%-15s%-15s%-15s%-15s\n","Payment #","Interest", "Principal","Balance");
		
		int i=1;		
		while (i <= 12) {
			if (i==1) {
			monthlyInterest=monthlyInterestRate*loanAmount;
			balance=loanAmount*monthlyInterestRate+loanAmount-monthlyPay;
			principal=monthlyPay-monthlyInterest;
			}
			else {
			monthlyInterest=monthlyInterestRate*balance;
			balance=balance*monthlyInterestRate+balance-monthlyPay;
			principal=monthlyPay-monthlyInterest;
			}
			
			System.out.printf("%-15d%-1s%-14.2f%-1s%-14.2f%-1s%-14.2f\n",i,"$",monthlyInterest,"$",principal,"$",balance);
			i++;
		}
	}
}