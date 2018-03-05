package main.questions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author radhikakalaiselvan
 *The main class to run the code.Can give input file as command line argument or run without any arguments to
 *enter input using the console.
 */
public class RollingNumbersDriver {

	private static Scanner in;

	public static void main(String[] args) {
		try{
			if(args.length>0){
				in=new Scanner(new File(args[0]));
			}else{
				System.out.println("Enter window sizes");
				in = new Scanner(System.in);
			}

			int w1=in.nextInt();
			int w2=in.nextInt();
			StatisticsGenerator sg=new StatisticsGenerator(w1,w2);
			while(in.hasNext()){
				String num=in.next();
				int validNumber=Integer.parseInt(num);
				sg.printStatistics(validNumber);
			}
		}catch(NumberFormatException ne){
			System.out.println("Invalid input");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
