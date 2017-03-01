package basic;

import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Class DateDifference
 * The class is to support calculating the total difference between 2 date2 input from user.
 * @author Steven Quach
 *
 */
public class DateDifference {
	/**
	 * main function of the class which utilizes main input and output
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException{
		String currDir = System.getProperty("user.dir");
//		System.out.println("currDir "+currDir);
		Scanner sc = new Scanner(new FileReader(currDir+"/src/basic/DateInput.txt"));
		int  totalDiff = 0;
		
		/**
		 * For testing if date2 later than date1 or not, you can comment out this line of code 
		 */
		//Scanner sc = new Scanner(new FileReader(currDir+"/src/basic/DateInput2.txt"));
		
		//loop through line of the input file to process
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println("original input: "+str);
			
			//calculate the difference
			  totalDiff = totalDiff(str);
			System.out.println("Total Difference: "+ totalDiff+" day(s)");
			System.out.println("=================End=========");
		}
	}
	/**
	 * function isLeapYear()
	 * check which the year is a leap year 
	 * @param year
	 * @return isLeapYear
	 */
	public static boolean isLeapYear(int year){
		boolean  isLeapYear =((year % 4==0) && (year % 100!=0) || year % 400==0);
		return isLeapYear;
	}
	/**
	 * function totalDiff()
	 * calculate the total Difference between 2 dates from user input and return total dates different.
	 * @param day1
	 * @param month1
	 * @param year1
	 * @param day2
	 * @param month2
	 * @param year2
	 * @return totalDiff
	 */
	public static int totalDiff(String str) throws InputMismatchException{
		String[] strArr = str.split(",");
		String date1, date2;
		int day1, month1, year1;
		int day2, month2, year2;
		int totalDiff;
		//validate input just for 2 dates at one time
		if(strArr.length != 2){
			System.out.println("Invalid Input Formate! The input should contain only 2 dates for calculation!");
			throw new InputMismatchException();
		}
		date1 = strArr[0].trim();
		date2 = strArr[1].trim();
		
		day1 = Integer.parseInt(date1.split(" ")[0]);
		month1 = Integer.parseInt(date1.split(" ")[1]);
		year1 = Integer.parseInt(date1.split(" ")[2]);
		
		day2 = Integer.parseInt(date2.split(" ")[0]);
		month2 = Integer.parseInt(date2.split(" ")[1]);
		year2 = Integer.parseInt(date2.split(" ")[2]);
		
		//validate user input range of dates should  between 1990 and 2010
		if(1990>year1 || year1>2010 || 1990>year2 || year2>2010){
			System.out.println("\nInvalid Input Format! Year(s) input should between 1990 and 2010");
			return -1;
//			throw new InputMismatchException();
		}
		//validate input: Second dates must later than the first date
		if(!isValidInput(day1, month1, year1, day2, month2, year2)){
			System.out.println("\nInvalid Input Format! Second Date must later than First Date!Please correct your last input.");
			return -2;
//			throw new InputMismatchException();
		}
			
		System.out.println("input is: "+ day1+" " + month1+" "+ year1+" "+ day2+" "+ month2+" "+ year2);
		
		int totalDays1 = calculateInputDate(year1, month1, day1);
		System.out.println("totalDays1 "+totalDays1);
		int totalDays2 = calculateInputDate(year2, month2, day2);
		System.out.println("totalDays2 "+totalDays2);
		
		totalDiff = totalDays2-totalDays1;
		System.out.println("totalDays2 - totalDays1 = "+totalDiff);
		return totalDiff;
		
	}
	/**
	 * function calculateInputDate()
	 * calculate the total of Days from the input date
	 * @param year
	 * @param month
	 * @param day
	 * @return totalDays
	 */
	public static int calculateInputDate(int year, int month, int day){
		int totalDays = 0;
		int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//calculate from year 1st to the (year-1) year
		for(int y =1; y<year; y++){
			if(isLeapYear(y)){
				totalDays +=366;
			}
			else
				totalDays +=365;
		}
		System.out.println("totalDays inlude only year "+totalDays);
		//calculate the last month of the input year by user
		for(int m = 1; m<month;m++){
			daysInMonth[2] = isLeapYear(year) ? 29 : 28;
			totalDays += daysInMonth[m];
		}
		System.out.println("totalDays included month "+totalDays);
		//calculate the last  day of the input year by user
		totalDays += day;
		System.out.println("totalDays included day "+totalDays);
		return totalDays;
	}
	/**
	 * function isValidInput()
	 * check if user input is valid
	 * @param day1
	 * @param month1
	 * @param year1
	 * @param day2
	 * @param month2
	 * @param year2
	 * @return isValidInput
	 */
	public static boolean isValidInput(int day1, int month1, int year1, int day2, int month2, int year2){
		boolean isValidInput = false;
		if(year1 == year2) 
				if(month1==month2){
					if(day1<=day2)
						isValidInput = true;
				}else if(month1<month2){
					isValidInput = true;
				}
		if(year1<year2){
					isValidInput = true;
		}
		return isValidInput;
	}
}
