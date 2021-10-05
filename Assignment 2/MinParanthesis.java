package javPrac;

import java.util.Scanner;

public class MinParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int openPar = 0, ans = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '(') {
				openPar++;	
			}else if(str.charAt(i) == ')') {
				openPar--;
			}if(openPar == -1) {
				ans++;
				openPar++;
			}
		}
		System.out.println(ans + openPar);
	}

}
