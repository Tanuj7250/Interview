package sopraAssignementConsoleApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SopraConsoleAppFunc {
		
	TreeMap<Integer, String> taskMap = new TreeMap<Integer, String>();
	TreeMap<Integer, String> deletedTaskMap = new TreeMap<Integer, String>();
	Scanner taskString = new Scanner(System.in);
	
	//Method to handle Single task
	public void singleTask(int count){
		String tasks = taskString.nextLine();
		taskMap.put(count, tasks);		
	}

	//Method to handle Multiple task
	public int multipleTask(int count){
        Scanner input = new Scanner(System.in);
        String tasks;
        List<String> multipleTask = new ArrayList<String>();
        while (!(tasks = input.nextLine()).isEmpty()) {
        	multipleTask.add(tasks);
        }
        for(String multTask : multipleTask) {
        	taskMap.put(count, multTask);
        	count++;
        }
        return count;
    }
	
	//Method to List Task
	public void listTask(){

		try {
			String outputFilePath = "D:\\Softwares\\TaskList-data.txt";
			PrintWriter writer = new PrintWriter(outputFilePath);
			//BufferedWriter bw = null;
			Set<Map.Entry<Integer, String>> setTm = taskMap.entrySet();
			for(Map.Entry<Integer, String> me : setTm) {
				System.out.println("------------> " + me.getKey() + " : "+me.getValue());
				//System.out.println(me.getValue());
				writer.println( "------------> " + me.getKey() + " : "+me.getValue() );
				
			}
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to Delete Task
	public void deleteTask(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter Task Number to Delete the Task");
		int key = input.nextInt();
		String taskName = (String)taskMap.remove(key); 
		deletedTaskMap.put(key, taskName);
	}
	
	//Method to handle Track Deleted Task
	public void trackDeletedTask(){
		Set<Map.Entry<Integer, String>> setTm = deletedTaskMap.entrySet();
		for(Map.Entry<Integer, String> me : setTm) {
			System.out.println("------------> " + me.getKey() + " : "+me.getValue());
		}		
	}	
}
