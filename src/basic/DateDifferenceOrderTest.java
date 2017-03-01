package basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DateDifferenceOrderTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		DateDifference diff = new DateDifference();
		int totalDiff=-1;
		String currDir = System.getProperty("user.dir");
		Scanner sc = new Scanner(new FileReader(currDir+"/src/basic/DateInputForTestCase2.txt"));
			while(sc.hasNext()){
				String str = sc.nextLine();
				totalDiff = diff.totalDiff(str);
				if(totalDiff == 1){
					System.out.println("First test data");
					System.out.println("Expected output = 1\n-->TestCase Pass For the First Test Data in DateInputForTestCase2.txt file\n");
				}else{
					System.out.println("Second test data");
					System.out.println("totalDiff "+totalDiff);
					System.out.println("Test(s) Fail! The second date should be later than the first date!");
					throw new InputMismatchException();
				}
			}
	}

}
