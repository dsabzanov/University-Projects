import java.util.*;
import java.io.*;

public class Sudoku {

	public static final int rows = 9;
	public static final int cols = 9;
	public static int[][] board = new int[rows][cols];
	
	//-------------------------------------------------
	// show()
	// print the contents of the board to the display
	//-------------------------------------------------

	public static void show() {
		System.out.println("    1  2  3   4  5  6   7  8  9");
		System.out.println();
		for (int i = 0; i<rows; i++) {
			System.out.print(i+1 + "  ");
			for (int j=0; j<cols; j++) {
				//System.out.print(" "+ board[i][j]);
				if (board[i][j] == 0) {
					System.out.print(" _ ");
				}
				else {
					System.out.print(" "+ board[i][j] + " ");
				}
				if (j == 2 || j == 5) {
					System.out.print("|");
				}
					
			}
			System.out.println("  ");
			if (i == 2 || i == 5) {
				System.out.println("   -----------------------------");
			}
		}
	}
	
	//-------------------------------------------------
	// load()
	// load the contents of a clue file from the file system
	//-------------------------------------------------
	
	public static void load(String filename) {
		Scanner fin = null;
		try { fin = new Scanner(new FileReader(filename)); }
		catch (Exception e) {
			System.out.println("Error opening file " + filename);
			System.exit(0);
		}
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				board[i][j] = fin.nextInt();
			}
		}
	}
	
	public static boolean setValue(int r, int c, int v) { 
		board[r][c] = v;	
		return true;
	} 
	
	public static boolean canAddToRow(int r, int v) {
		for (int c=0; c<cols; c++) {
			if (v == board[r][c]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean canAddToColumn(int c, int v) { 
		for (int r=0; r<rows; r++) {
			if (v == board[r][c]) {
				return false;
			}
		}
		return true;
	}
	public static boolean canAddToSubgrid(int r, int c, int v) { 
		r = r/3*3;
		c = c/3*3;
		for (int i=r; i<r+3; i++) {
			for (int j=c; j<c+3; j++) {
				if (board[i][j] == v) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isComplete() {
  		for (int r = 0; r<9; r++) {
			for (int v=1; v<=9; v++) {
				if(canAddToRow(r,v)) {
					return false;
				}
			}
		}
		for (int c = 0; c<9; c++) {
			for (int v=1; v<=9; v++) {
				if (canAddToColumn(c,v)) {
					return false;
				}
			}
		}
		for (int r = 0; r<9; r++) {
			for (int c = 0; c<9; c++) {
			for (int v=1; v<=9; v++) {
				if(canAddToSubgrid(r,c,v)) {
					return false;
				}
			}
			}
		}
		return true;	
	}
	
	public static void hint(int r, int c) {
		// boolean[] rc = new boolean[10];
//    	boolean[] cc = new boolean[10];
//    	boolean[] sgc = new boolean[10];
//  		for (int value = 1; value<=9; value++) {
//  			int b = canAddToRow(r, value);
//    		rc[value] = b;
//    	}
//    	System.out.print("Possible values are: ");
//    	for (int value = 1; value<=9; value++) {
//    		if (rc[value] == true && cc[value] == true && sgc[value] == true) {
//    			System.out.print(value + " ");
//    		}
//    		else {
//    			System.out.print("  ");
//    		}
//    	}
	}
	
	public static void commandline() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("> ");
			
			String line = in.nextLine();
			String[] t = line.split(" ");
			String cmd = t[0];
			if (cmd.equals("quit") || cmd.equals("Quit")) {
				break;
			}
			else if (cmd.equals("show") || cmd.equals("Show")) {
				show();
			}
			else if (cmd.equals("load") || cmd.equals("Load")) {
				load("clues.txt");
			}
			
			else if (cmd.equals("set") || cmd.equals("Set")) {
				int r = Integer.parseInt(t[1]);
				int c = Integer.parseInt(t[2]);
				int v = Integer.parseInt(t[3]);
				r--;
				c--;
				boolean rcheck = canAddToRow(r,v);
				boolean ccheck = canAddToColumn(c,v);
				boolean scheck = canAddToSubgrid(r,c,v);
				if (rcheck && ccheck && scheck) {
					setValue(r,c,v);
				}
				else {
					System.out.println("Error");
				} 
			}
			
			else if (cmd.equals("complete") || cmd.equals("Complete")) {
				isComplete();
				if (isComplete() == true) {
					System.out.println("True");
				}
				else {
					System.out.println("False");
				}
			}
			
			else if (cmd.equals("hint") || cmd.equals("Hint")) {
  				//hint(r,c); 
  				//System.out.println("Row "+r+" is missing: "+rc[]);
 				//System.out.println("Column "+c+" is missing: "+cc[]);
 				//System.out.println("Subgrid is missing: "+sgc[]);
			}
			
			else {
				System.out.println("Input not recognized");
			}
		}
	}
	
	public static void main(String[] args) {
		//show();
		
		// load("clues.txt");
// 		System.out.println();
// 		show();
		commandline();
	}
}