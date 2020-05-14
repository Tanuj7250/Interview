package soperaAssignementConsoleApp;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter the List");
		//int n = scan.nextInt();
		char ch;
		String str;
		int i = 0;
		ArrayList<String> al = new ArrayList<String>();
		do{
			System.out.println("\n++++++++++++ TO DO LIST ++++++++++++");
			System.out.println("1. Enter the item");
			System.out.println("2. Show List");
			System.out.println("3. Show All the Task");
			System.out.println("4. Show Deleted item");
			int choice = scan.nextInt();
			switch (choice){
			case 1 : 
				System.out.println("Enter the Task");
				try{
					str = scan.next();
					al.add(str);
					System.out.println(" Item Is Entered : ");
				}
				catch (Exception e){
					System.out.println("Error : " + e.getMessage());
				}                         
				break;    
			case 2 : 
				System.out.println("Show The Task");
				try{
					
					System.out.println("Entered item is : "+al.get(i));
					i++;
				}
				catch (Exception e){
					System.out.println("Error : " + e.getMessage());
				}                         
				break;    
			case 3 : 
				System.out.println("Show All The Task");
				try{
					for(int j = 0; i < al.size(); j++) {
						System.out.println("Tasks are :"+ j + ":- " +al.get(j));
					}
				}
				catch (Exception e){
					System.out.println("Error : " + e.getMessage());
				}                         
				break;                 
			case 4 : 
				System.out.println("Delete a Task");
				try{
					i++;
					System.out.println("Deleted item is : "+al.remove(i));
				}
				catch (Exception e){
					System.out.println("Error : " + e.getMessage());
				}                         
				break;                  
			default : 
				System.out.println("Wrong Entry \n ");
				break;
			}
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);			
		}while(ch == 'Y'|| ch == 'y');
	}

}
