package com.avi.timetracker;

import com.avi.timetracker.data.Category;
import com.avi.timetracker.data.CurrentTask;
import com.avi.timetracker.data.Task;

public class TimeTracker {

    public static void main(String[] args) {

        //Arrays.stream(args).forEach(System.out::println);

        if (args.length < 2){
            Logger.log("Error! Not enough arguments!");
        }
        String command=args[0];

        // Get currentTasks from file
        CurrentTask currentTask = new CurrentTask();

        switch (command) {
            case "start":
                String taskName = args[1];
                String categoryName = args.length == 3 ? args[2] : Category.NONE;
                
                Task task= new Task(taskName, new Category(categoryName));
                currentTask.startTask(task);
                break;
        
            case "stop":
                break; 
            default:
                break;
        }



    }
}




//To run with parameters
//& 'C:\Users\avish\.vscode\extensions\redhat.java-1.33.0-win32-x64\jre\17.0.11-win32-x86_64\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\avish\OneDrive\Desktop\java-proj-1\time-tracker\target\classes' 'com.avi.timetracker.TimeTracker' 'param1' 'param2' 'param3'
