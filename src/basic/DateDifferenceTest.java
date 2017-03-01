package basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * class  DateDifferenceTest()
 * Including Test Cases for DateInputForTestCase.txt. Design for testing the methods in DateDifference.java
 * 
 * @author Steven Quach
 * 
 * */
public class DateDifferenceTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		DateDifference diff = new DateDifference();
		int totalDiff=0;
		String currDir = System.getProperty("user.dir");
		
		Scanner sc = new Scanner(new FileReader(currDir+"/src/basic/DateInputForTestCase.txt"));
		while(sc.hasNext()){
			String str = sc.nextLine();
			totalDiff = diff.totalDiff(str);
			if(totalDiff == 5){
				System.out.println("First test data");
				System.out.println("Expected output = 5\n-->TestCase Pass For Test Data in DateInputForTestCase.txt file");
			}else if(totalDiff == 0){
				System.out.println("Second test data");
				System.out.println("Expected output = 0\n-->TestCase Pass For Test Data in DateInputForTestCase.txt file");
			}else if(totalDiff == 29){
				System.out.println("Third test data");
				System.out.println("Expected output = 29\n-->TestCase Pass For Test Data in DateInputForTestCase.txt file");
			}else{
				System.out.println("Test(s) Fail! Expected date = 29 instead of "+totalDiff);
				throw new InputMismatchException();
			}
		}
		
	}

}
