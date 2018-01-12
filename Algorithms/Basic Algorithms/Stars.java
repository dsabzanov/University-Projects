/*
Programmer: David Sabzanov
Project#: 11
Due Date: Thursday, November 8, 2012
Class: Comp 108 9:30-10:45
Description: A Java program that
displays:
		    *
		   **
		  ***
		 ****
		*****
*/

public class Stars
{
	public static void main(String []args)
	{
		for(int i = 0 ; i < 5 ; ++i){
      	for(int x = 5 ; x >= 0 ; --x) {
            if ( x > i ){ 
					System.out.print(" "); 
				}
            else {
					System.out.print("*"); 
				}
      	}
      	System.out.println();
    	}
	}
}
/*
     ----jGRASP exec: java Stars
    
         *
        **
       ***
      ****
     *****
    
     ----jGRASP: operation complete.
*/    