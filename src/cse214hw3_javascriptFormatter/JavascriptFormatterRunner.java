/**
 * Trung Vo
 * email: trung.vo@stonybrook.edu
 * ID # 109845485
 * CSE 214 R03
 * Homework 3
 */
package cse214hw3_javascriptFormatter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JavascriptFormatterRunner {

	public static void main(String[] args) throws IOException {
		JavascriptFormatter js = new JavascriptFormatter();
		
		System.out.print("Enter a name of a file: ");
		String str = (new java.util.Scanner(System.in)).nextLine();
		java.io.File file = new java.io.File(str);
		if (!file.exists())
			System.out.println("File not found.");
		else {
			Scanner input = new Scanner(file);
			String line = "";
			
			while (input.hasNextLine()) {
				line += input.nextLine();
			}
			System.out.println(js.format(line));
		}
	}

}
