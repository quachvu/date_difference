package basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class  DateDifferenceTest()
 * Including Test Cases for DateInputForTestCase1.txt. Design for testing the methods in DateDifference.java
 * For testing data out of range from 1990 and 2010, you can comment out this line of code
 * @author Steven Quach
 * @throw IOException
 * */
public class DateDifferenceInRangeTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		DateDifference diff = new DateDifference();
		int totalDiff=-1;
		String currDir = System.getProperty("user.dir");
		Scanner sc= new Scanner(new FileReader(currDir+"/src/basic/DateInputForTestCase1.txt"));
			while(sc.hasNext()){
				String str = sc.nextLine();
				totalDiff = diff.totalDiff(str);
				if(totalDiff == 365){
					System.out.println("First test data");
					System.out.println("Expected output = 365\n-->TestCase Pass For First Test Data in DateInputForTestCase1.txt file\n");
				}else{
					System.out.println("Second test data");
					System.out.println("totalDiff "+totalDiff);
					System.out.println("Test(s) Fail! The 2 dates should be in range from 1990 to 2010");
					throw new InputMismatchException();
				}
			}
	}

}
