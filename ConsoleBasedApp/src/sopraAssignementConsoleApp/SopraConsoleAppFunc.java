package sopraAssignementConsoleApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
	final static String path = "D:\\Softwares\\TaskList-data.txt";

	public int  getHashMapFromTextFile(){
		BufferedReader br = null;
		try{
			File file = new File(path);
			br = new BufferedReader( new FileReader(file) );
			String line = null;
			while ( (line = br.readLine()) != null ){
				String[] parts = line.split(":");
				Integer key = Integer.parseInt(parts[0].trim());
				String task = parts[1].trim();
				if( !key.equals("") && !task.equals("") ) {
					taskMap.put(key, task);
					saveTask();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try { 
					br.close(); 
				}catch(Exception e){};
			}
		}
		if(!taskMap.isEmpty()) {
			return taskMap.lastKey() + 1;
		}else {
			return 1;
		}
	}

	//Method to handle Single task
	public void singleTask(int count){
		String tasks = taskString.nextLine();
		taskMap.put(count, "[] " +tasks);	
		saveTask();
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
			taskMap.put(count, "[] " +multTask);
			count++;
		}
		saveTask();
		return count;
	}

	//Method to List Task
	public void listTask(){
		//BufferedWriter bw = null;
		Set<Map.Entry<Integer, String>> setTm = taskMap.entrySet();
		for(Map.Entry<Integer, String> me : setTm) {
			System.out.println("------------> " + me.getKey() + " : "+me.getValue());

		}	
	}

	//Method to Delete Task
	public void deleteTask(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter Task Number to Delete the Task");
		int key = input.nextInt();

		if(taskMap.containsKey(key)) {
			String taskName = (String)taskMap.remove(key); 
			ArrayList<Integer> newKey = new ArrayList<Integer>();
			ArrayList<String> newValue = new ArrayList<String>();
			deletedTaskMap.put(key, taskName);
			Set<Map.Entry<Integer, String>> setTm = taskMap.tailMap(key).entrySet();
			for(Map.Entry<Integer, String> me : setTm) {
				newKey.add(me.getKey()-1);
				newValue.add(me.getValue());
			}
			for(int i = 0; i < newKey.size(); i++) {
				taskMap.put(newKey.get(i), newValue.get(i));

			}
			taskMap.remove(taskMap.lastKey());
			saveTask();
		}else {
			System.out.println("KEY DOES NOT EXIST ");
		}
		//System.out.println("newKey "+newKey);
		//System.out.println("newValue "+newValue);
	}

	//Method to handle Track Deleted Task
	public void trackDeletedTask(){
		String deletedPath = "D:\\Softwares\\Deleted-TaskList-data.txt";
		try {
			Set<Map.Entry<Integer, String>> setTm = deletedTaskMap.entrySet();
			PrintWriter writer = new PrintWriter(deletedPath);
			for(Map.Entry<Integer, String> me : setTm) {
				System.out.println("------------> " + me.getKey() + " : "+me.getValue());
				writer.println(me.getKey() + " : "+me.getValue() );
			}
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	

	public void markTaskCompleted(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter Task Number which is Completed");
		int taskNum = input.nextInt();
		if(taskMap.containsKey(taskNum)) {
			taskMap.put(taskNum, taskMap.get(taskNum).replace("[]", "[X]"));
			saveTask();
		}else {
			System.out.println("TASK Do not Exist");
		}
	}

	public void saveTask() {
		String outputFilePath = path;
		try {
			PrintWriter writer = new PrintWriter(outputFilePath);
			Set<Map.Entry<Integer, String>> setTm = taskMap.entrySet();
			for(Map.Entry<Integer, String> me : setTm) {
				writer.println(me.getKey() + " : "+me.getValue() );
			}
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
