package sopraAssignementConsoleApp;

import java.util.Scanner;

public class SopraConsoleApp {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		showMainMenu();
	}

	public static void showMainMenu() {
		final Scanner option = new Scanner(System.in);
		int deletedTaskCount = 1;
		SopraConsoleAppFunc singletaskObj = new SopraConsoleAppFunc();
		int count = singletaskObj.getHashMapFromTextFile();
		try{
			while (true) {
				System.out.println("\n++++++++++++ TO DO LIST APP ++++++++++++\n");
				System.out.println("1. Enter a single Task");
				System.out.println("2. Enter Multiple Tasks");
				System.out.println("3. Show All the Tasks");
				System.out.println("4. Mark Task Completed");
				System.out.println("5. Delete the Task");
				System.out.println("6. Track Delete Task");
				System.out.println("\n++++++++++++ Please Enter the Choice ++++++++++++\n");
				switch(option.nextInt()) {
				case 1:
					System.out.println("\n*************** Entering Single Task ***************\n");
					singletaskObj.singleTask(count++);
					break;
				case 2:
					System.out.println("\n*************** Entering Multiple Task ***************\n");
					count = singletaskObj.multipleTask(count);
					break;
				case 3:
					System.out.println("\n*************** Show Task ***************\n");
					//singletaskObj = new SopraConsoleAppFunc();
					singletaskObj.listTask();					
					break;
				case 4:
					System.out.println("\n*************** Mark Task Completed***************\n");
					//singletaskObj = new SopraConsoleAppFunc();
					singletaskObj.markTaskCompleted();					
					break;					
				case 5:
					System.out.println("\n*************** Delete Task ***************\n");
					singletaskObj.deleteTask();
					break;
				case 6:
					System.out.println("\n*************** Track Deleted Task ***************\n");
					singletaskObj.trackDeletedTask();
					break;
				default:
					System.out.println("\n*************** Wrong Choice ***************\n");
					break;

				}
			}
		}catch(Exception exp) {
			System.out.println("\n*************** Wrong Choice ***************\n");
		}
	}
}
