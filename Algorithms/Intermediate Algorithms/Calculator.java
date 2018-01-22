// David Sabzanov
// Comp 110
// Prof. Covington
// Project 7 Line Oriented Calculator

import java.util.*;
import java.io.*;

public class Calculator {
	public static void main(String[] args) throws Exception {
		commandline();
	}
	
	public static int maxsymbols = 100;
	public static String[] symbols = new String[maxsymbols];
	public static int[] values = new int[maxsymbols];
	public static int symbolcount = 0;
	
	public static int lookup(String s) {
		for (int i=0; i<symbolcount; i++) {
			if (s.equals(symbols[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public static void addsymbol(String s) {
		for (int i=0; i<symbolcount; i++) {}
	}
	
	public static int eval(String s) {
		char c = s.charAt(0);
		if (Character.isDigit(c)) {
			return Integer.parseInt(s);
		}
		else {
			int x = lookup(s);
			if (x == -1) {
				//error
				return -1;
			}
			else {
				return values[x];
			}
		}
	}
	
	public static int eval(String s2, String op, String s3) {
		int a = eval(s2);
		int b = eval(s3);
		if (op.equals("+")) {
			return a+b;
		}
		if (op.equals("-")) {
			return a-b;
		}
		if (op.equals("*")) {
			return a*b;
		}
		if (op.equals("/")) {
			return a/b;
		}
		return -1;
	}
		
	public static int getsymbolvalue(String s) {
		int result = lookup(s);
		return result;
	}
	
	public static void setsymbolvalue(String s, int v) {
		int result = lookup(s);
		if (result == -1) {
			symbols[symbolcount] = s;
			values[symbolcount] = v;
			symbolcount++;
		}
		else {
			values[result] = v;
		}
	}
	
	public static String[] tokenize(String s) {
		String[] tokens = s.split(" ");
		return tokens;
	}
	
	public static void show() {
		if (symbolcount == 0) {
			System.out.println("Table is empty");
		}
		else {
			for (int i=0; i<symbolcount; i++) {
				System.out.println(symbols[i]+" = " +values[i]);
			}
		}
	}
	
	public static void help() {
		System.out.println("Avaliable Commands: ");
		System.out.println("show: lists the current value of all symbols");
		System.out.println("help: prints this help message");
		System.out.println("quit: terminates the program");
		System.out.println();
		System.out.println("To operate the calculator enter: ");
		System.out.println("<symbol> = <constant or symbol> ex: y = 5 or y = z");
		System.out.println("<symbol> = <expression> Expressions are limited to the following form:");
		System.out.println("		<constant or symbol> <operation> <constant or symbol> ex: y = 5 + 2 or d = v - 3");	
	}
	
	public static boolean checkinput(String[] t) {
		return true;
	}
	
	public static void commandline() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String prompt1 = "Calculator 1.0";
		String prompt2 = ">> ";
		
		System.out.println(prompt1);
		System.out.print(prompt2);
		String line = in.readLine();
		
		while (! line.equals("quit")) {
			String[] tokens = tokenize(line);
			boolean okay = checkinput(tokens);
			if (okay) {
				if (tokens.length==1) {
					if (tokens[0].equals("help")) help();
					else if (tokens[0].equals("show")) show();
				}
				else if (tokens.length == 3) {
					int v = eval(tokens[2]);
					setsymbolvalue(tokens[0],v);
					System.out.println(tokens[0] + " = " + v);
				}
				else {
					int v = eval(tokens[2],tokens[3],tokens[4]);
					setsymbolvalue(tokens[0],v);
					System.out.println(tokens[0] + " = " + tokens[2] + " " + tokens[3] + " " + tokens[4]);
				}
			}
			System.out.print(prompt2);
			line = in.readLine();
		}
	}

	
	// public static void commandline() {
// 		Scanner in = new Scanner(System.in);
// 		while (true) {
// 			System.out.print("> ");
// 			String line = in.nextLine();
// 			String[] t = line.split(" ");
// 			String cmd = t[0];
// 			
// 			if (cmd.equals("quit") || cmd.equals("Quit")) {
// 				break;
// 			}
// 			else if (cmd.equals("show") || cmd.equals("Show")) {
// 				show();
// 			}
// 			else if (t.length == 3) {
// 				String s = t[0];
// 				int v = Integer.parseInt(t[2]);
// 				setsymbolvalue(s, v);
// 			}
// 			else if (t.length == 5) {
// 				String s = t[0];
// 				int v = Integer.parseInt(t[2]);
// 				int v2 = Integer.parseInt(t[4]);
// 				if (t[3].equals("+")) {
// 					v = v + v2;
// 				}
// 				if (t[3].equals("-")) {
// 					v = v - v2;
// 				}
// 				if (t[3].equals("*")) {
// 					v = v * v2;
// 				}
// 				if (t[3].equals("/")) {
// 					v = v/v2;
// 				}
// 				setsymbolvalue(s, v);
// 				
// 			}
// 			else if (cmd.equals("help") || cmd.equals("Help")) {
// 				help();
// 			}
// 			else {
// 				System.out.println("Input not recognized");
// 			}
// 		}
// 	}
}