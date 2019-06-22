package wipBackEnd;

import java.util.Scanner;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String you wish to enter: -");
		String str = sc.nextLine();
		int a = 0; //Assigned to track Starting char position of the string
		int len = str.length() - 1;
		while(len >= 0) {
			if(str.charAt(a) == str.charAt(len)) {
				a++;
			}
			len--;
		}
		String starting = str.substring(a);
		String ending  = new StringBuilder(starting).reverse().toString();
		//String Builder because reverse function is present in StringBuilder 
		//and toString Because  to convert StringBuilder back to String
		String mid = str.substring(0, a);
		System.out.println("mid "+mid);
		String shortestPalindrome = starting + mid + ending;
		
		}

}
