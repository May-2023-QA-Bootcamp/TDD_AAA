package unit;

import java.util.Scanner;

public class SimpleCalculator {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String userString = System.getProperty("user.name");
		System.out.println("Hi "+userString+"! Welcome to virtual calculator");
		System.out.println("Type add for addition, multiply for multiplication");
		
		String input = scanner.next();
		while(!input.equalsIgnoreCase("exit")) {
			scanner = new Scanner(System.in);
			System.out.println("---------------");
			System.out.println("Type only add or multiply");
			System.out.println("Or if you want to exit type exit");
			input = scanner.next();
			
			if(input.equalsIgnoreCase("add")) {
				System.out.println("Type your numbers separated by comma. e.g 1,2,3,");
				scanner = new Scanner(System.in);
				String [] arr = scanner.next().split(",");
				int [] intArr = new int[arr.length];
				for(int i = 0; i < arr.length; i++) {
					intArr[i] = Integer.parseInt(arr[i]);
				}
				int result = addition(intArr);
				System.out.println("Your result is : " + result);
			}else if(input.equalsIgnoreCase("multiply")) {
				System.out.println("Type your numbers separated by comma. e.g 1,2,3,");
				scanner = new Scanner(System.in);
				String [] arr = scanner.next().split(",");
				int [] intArr = new int[arr.length];
				for(int i = 0; i < arr.length; i++) {
					intArr[i] = Integer.parseInt(arr[i]);
				}
				int result = multiply(intArr);
				System.out.println("Your result is : " + result);
			}
		}
	}
	
	public static int addition(int... arr) {
		int result = 0;
		for(int i : arr) {
			result += i;
		}
		return result;
	}
	
	public static int multiply(int... arr) {
		int result = 1;
		for(int i : arr) {
			result = result * i;
		}
		return result;
	}
}
