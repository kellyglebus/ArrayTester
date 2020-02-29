import java.util.*;
public class arrayTester{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter how long you want your array: ");
		int x = sc.nextInt();
		int arr[] = new int[x];
		System.out.println("Enter all the elements: ");
		for (int i = 0; i < x; i++){
			arr[i] = sc.nextInt();
		}
		changeMyArray(arr, x);
	}
	
	public static void changeMyArray(int[] arr, int x){
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		//Continues to alter array until user is finished
		while(check){
			System.out.println("What would you like to do with the array? "
								+ "Enter: Check a value, Add a value, Subtract a value, "
								+ "Multiply a value, Divide a value, Change out a value, "
								+ "or Exit?: ");
			String ans = sc.nextLine();
			ans.toLowerCase();
			
			//Prints the value(s) at indicated indexes 
			if (ans.equals("check a value")){
				System.out.println("Check 1 value or all values? Enter 1 or all: ");
				String a = sc.nextLine();
				if(a.equals("1")){
					System.out.println("Which index would you like to check? ");
					int w = sc.nextInt();
					w = checkIndex(arr, w);
					System.out.println("The value at index " + w + " is: " + arr[w]);
				}
				else{
					printArray(arr);
				}
			}
			
			//Adds value(s) to the elements in the array 
			else if (ans.equals("add a value")){
				System.out.println("Would you like to add a value to 1 elements of all elements?"
								   + " Enter 1 or all: ");
				String a = sc.nextLine();
				if(a.equals("1")){
					System.out.println("Which index would you like to add to? ");
					int w = sc.nextInt();
					w = checkIndex(arr, w);
					System.out.println("How much would you like to add? ");
					int y = sc.nextInt();
					arr[w] = arr[w]+y;
					printArray(arr);
				}
				else{
					System.out.println("How much would you like to add? ");
					int y = sc.nextInt();
					changeAll(arr, y, "+");
				}
			}
			
			//Subtracts value(s) form the elements of the array 
			else if (ans.equals("subtract a value")){
				System.out.println("Would you like to subtract a value from 1 element or all elements?"
								   + " Enter 1 or all: ");
				String a = sc.nextLine();
				if(a.equals("1")){
					System.out.println("Which index would you like to add to? ");
					int w = sc.nextInt();
					w = checkIndex(arr, w);
					System.out.println("How much would you like to subtract? ");
					int y = sc.nextInt();
					arr[w] = arr[w]-y;
					printArray(arr);
				}
				else{
					System.out.println("How much would you like to subtract? ");
					int y = sc.nextInt();
					changeAll(arr, y, "-");
				}
			}
			
			//multiplies value(s) in the arry
			else if (ans.equals("multiple a value")){
				System.out.println("Would you like to multiply a value to 1 element or all elements?"
								   + " Enter 1 or all: ");
				String a = sc.nextLine();
				if(a.equals("1")){
					System.out.println("Which index would you like to multiply? ");
					int w = sc.nextInt();
					w = checkIndex(arr, w);
					System.out.println("How much would you like to multiply by?: ");
					int y = sc.nextInt();
					arr[w] = arr[w]*y;
					printArray(arr);
				}
				else{
					System.out.println("How much would you like to multiply by? ");
					int y = sc.nextInt();
					changeAll(arr, y, "*");
				}
			}
			
			//divides values in the array 
			else if (ans.equals("divide a value")){
				System.out.println("Would you like to divide a value to 1 element or all elements?"
								   + " Enter 1 or all: ");
				String a = sc.nextLine();
				if(a.equals("1")){
					System.out.println("Which index would you like to divide? ");
					int w = sc.nextInt();
					w = checkIndex(arr, w);
					System.out.println("How much would you like to divide by? ");
					int y = sc.nextInt();
					y = checkZero(y);
					arr[w] = arr[w]/y;
					printArray(arr);
				}
				else{
					System.out.println("How much would you like to divide by?: ");
					int y = sc.nextInt();
					y = checkZero(y);
					changeAll(arr, y, "/");
				}
			}
			
			//changes values in the array 
			else if (ans.equals("change out a value")){
				System.out.println("Would you like to change out 1 element or all elements?"
								   + " Enter 1 or all: ");
				String a = sc.nextLine();
				if(a.equals("1")){
					System.out.println("Which index would you like to change out?: ");
					int w = sc.nextInt();
					w = checkIndex(arr, w);
					System.out.println("What value would you like to put in its place?: ");
					int y = sc.nextInt();
					arr[w] = y;
					printArray(arr);
				}
					
				else{
					arr = newArray();
				}
			}
			else if (ans.equals("exit")){
				check = false;
			}
			else{
				System.out.println("Sorry, I don't recognize that one. Can you try again?");
			}
		}
	}
	
	public static void printArray(int[] arr){
		System.out.print("Your array now holds: ");
		for (int i = 0; i < arr.length; i++){
			System.out.print("["+arr[i]+"] ");
		}
		System.out.println("\n");
	}
	
	public static int checkIndex(int[] arr, int w){
		Scanner sc = new Scanner(System.in);
		while((w > (arr.length - 1))||(w < 0)){
			System.out.println("Sorry that index is out of bounds. Try again: ");
			w = sc.nextInt();
			}
		return w;
	}
	
	public static int[] changeAll(int[] arr, int y, String ops){
		if(ops.equals("+")){
			for (int i = 0; i < arr.length; i++){
				arr[i] = arr[i] + y;
			}
		}
		else if(ops.equals("-")){
			for (int i = 0; i < arr.length; i++){
				arr[i] = arr[i] - y;
			}
		}
		else if(ops.equals("*")){
			for (int i = 0; i < arr.length; i++){
				arr[i] = arr[i] * y;
			}
		}
		else{
			for (int i = 0; i < arr.length; i++){
				arr[i] = arr[i] / y;
			}
		}
		printArray(arr);
		return arr;
	}
	
	public static int checkZero(int y){
	    Scanner sc = new Scanner(System.in);
		while(y == 0){
			System.out.println("We can't divide by zero! Please enter another number: ");
			y = sc.nextInt();
		}
		return y;
	}
	
	public static int[] changeAll(int[] arr){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter how long you want your array: ");
		int x = sc.nextInt();
		System.out.println("Enter all the elements: ");
		for (int i = 0; i < x; i++){
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	
	public static int[] newArray(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter how long you want your array: ");
		int x = sc.nextInt();
		int arr[] = new int[x];
		System.out.println("Enter all the elements: ");
		for (int i = 0; i < x; i++){
			arr[i] = sc.nextInt();
		}
		return arr;
	}
}