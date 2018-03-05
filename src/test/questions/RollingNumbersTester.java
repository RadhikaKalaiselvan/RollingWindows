package test.questions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import main.questions.StatisticsGenerator;

/**
 * @author radhikakalaiselvan
 *This is a test class, run this file to check the RollingNumbersDriver using pre-computed output file.
 */
public class RollingNumbersTester {

	public static void main(String[] args) {
		Scanner in,outFile;
		try {
			in = new Scanner(new File("/Users/radhikakalaiselvan/git/Versive/src/test/questions/input.txt"));
			outFile=new Scanner(new File("/Users/radhikakalaiselvan/git/Versive/src/test/questions/ExpectedOutput.txt"));
			StatisticsGenerator sg=new StatisticsGenerator(in.nextInt(),in.nextInt());
			while(in.hasNext() && outFile.hasNext()){
				//Assumption both the files are of same length
				String output=sg.printStatistics(in.nextInt()).toString().trim();
				String expected=outFile.next().trim();
				if(!output.equals(expected)){
					System.out.println("Test cases failed: Expected output :"+expected+", found :"+output+".");
					return;
				}
			}
			System.out.println("Test cases passed!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
