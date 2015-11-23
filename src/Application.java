
/*
 * David Casarrubias Mena
 * Joshua Cheseman
 * COSC 201
 * September 9, 2015
 * Lab 1
 * - Calculates sum of 3 integers entered by user
 * -reads in text file and prints out numbers in hexidecimal, octal, and binary
 * - prompts user for number and prints out fibonacci in recursive and iterative
 * - takes in values from user, storing them in array list, and calculates median, mean, maximum and minimum values. 
 */

import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


public class Application {
	public void textFile(){ // method for converting numbers into hexadecimal, octal, and binary
		ArrayList<Long>longs;   // creates array list with type Long, named longs.
		Scanner input = new Scanner(System.in);  // scanner 
		longs = new ArrayList<Long>();   
		try{
			Long temp;   // creates temporary variable to store number
			input = new Scanner(new File ("integers.txt"));   // read in text file 
			System.out.println("----------------------------");   // makes output neater and easier to read other methods
			while (input.hasNext()){
				temp = input.nextLong();  // stores temporary value 
				  System.out.printf("\n%o\n" , temp);  // reads and prints value from text file and converts to octal
				  System.out.printf("%x\n", temp);   // reads and prints value from text file and converts to hexadecimal
				  System.out.printf("%s\n", Long.toBinaryString(temp));  // reads and prints value from text file and converts to binary
			}
		}catch (Exception caught){
		
		}
	}
	public int sum(int a, int b, int c){ // method receives 3 integers and adds them together.
		return a + b + c; // returns sum of 3 integers
	}
	
	public void intsArray(){
		Scanner scan = new Scanner(System.in);
		int num;  // variable to store user input
		double median;  // variable used for calculating median later in program
		double total;   // variable used to keep track of total
		int mid;   // variable used for median value 
		total = 0;  // total initiated to 0
		double mean;  // variable used for mean later in array list calculation
		int counter; // counts the number of numbers the user enters. We prompt the user 3 times
		
		counter = 0;   // initiates counter for numbers entered by user
		
		ArrayList<Integer>numbers;   // creates array list called numbers with type Int.
		numbers = new ArrayList<Integer>(); 
		
		System.out.println("Running method for calculating min, max, mean, and median of numbers entered by user.........");
		System.out.println("Please enter a number: ");  // prompts user for number
		num = scan.nextInt();   // stores value in variable num
		numbers.add(num);   // takes value entered by user and stores it in array list called numbers
		counter+=1;   // adds 1 to counter 
		
		while(counter <=2){   // prompt user until we have 3 numbers. While set to <=2 because user was prompted once before while loop.
			System.out.println("Please print a number: ");  // prompts user for value
			num = scan.nextInt();  // stores value in variable num.
			numbers.add(num);  // adds number to array list called numbers.
			counter+=1;  // adds value to counter. stops prompting user when 3 numbers are entered by user. 
		}
		System.out.println("\n\n\nBiggest number entered is: "+Collections.max(numbers));  // prints out max of numbers from array list
		System.out.println("Smallest number entered is: "+Collections.min(numbers)); // prints out min of numbers from array list
		
		for (int list : numbers){  // goes through array list called numbers and adds up the total value which is then stored in variable total.
			total = total + list; 
		}	
		
		mean = total / numbers.size();  // mean is defined by dividing the sum of numbers in array list by the number of numbers in array list 
		System.out.println("The mean of the numbers entered is: " + mean);  // prints out mean of array list
		
		mid = numbers.size() / 2;  // middle number is obtained by obtaining size of arraylist and dividing it by 2.
		median = (double)numbers.get(mid); // median is then obtained by accessing the array list and obtaining the middle number
		
		if(numbers.size()%2 == 0){  //If the list can't be split evenly it will subtract one from the middlemost number and then divide it in half to get the median.
			median = (median + (double)numbers.get(mid - 1)) / 2;
		}
		
		System.out.println("The median is: " + median); // prints median of list of number 
		System.out.println("\n\n\n");
	}
	
	public int iterativeFibonacci(int n){ // method for calculating iterative 
		int result;  // variable result
		int previous; // variable for previous number
		int preprevious; // variable for preprevious number
		
		result = 1;  // set result equal to 1
		previous = 1; // sets previous equal to 1
		preprevious = 1; // sets preprevious equal to 1
		if(n >= 2){ 
			for(int i = 0; i < n-2; i++){
				result = previous + preprevious;
				preprevious = previous;
				previous = result;
			}
		}
		
		return result;
}
	public int recursiveFibonacci(int n){
		int result;
		
		if (n==1 || n ==2){
			result = 1;
		}else{
			result = recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
		}
		
		return result;
		
	}
	public static void main(String [] args){
		Scanner input;
		Application app = new Application();
		int num;
		int num2;
		int num3;
		int n;
		
		input = new Scanner(System.in);
		
		System.out.println("Enter first number: "); // prompt user for first number
		num = input.nextInt(); // store number in variable named num
		
		System.out.println("Enter second number: "); // prompt user for second number
		num2 = input.nextInt(); // store number in variable named num2
		
		System.out.println("Enter third number: "); // prompt user for 3rd number
		num3 = input.nextInt();  // store number in variable named num3
		
		
		System.out.println("The sum of the three numbers is: " + app.sum(num,num2 ,num3)); // pass three numbers to sum method and print result.
		
		System.out.println("-------Fibonacci numbers-------"); // beginning Fibonacci action
		System.out.println("Enter a number: ");
		n = input.nextInt();
		
		for (int i = 0; i < n; i++){
		 	System.out.println("Recursive: " +app.recursiveFibonacci(i+1) + ", " + "Iterative: "+app.iterativeFibonacci(i + 1));
			
		}
		System.out.println("\n\n\n");
		app.intsArray(); // calls method intsArray
		System.out.println("READING TEXT FILE AND CONVERTING NUMBERS: ");
		app.textFile();  // calls method textFile
		
}
}