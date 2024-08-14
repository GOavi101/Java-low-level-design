package com.avi.timetracker;

import java.io.IOException;
import java.net.URISyntaxException;

import com.avi.timetracker.data.Category;
import com.avi.timetracker.data.CurrentTask;
import com.avi.timetracker.data.Task;
import com.avi.timetracker.util.ArgUtil;
import com.avi.timetracker.util.Args;
import com.avi.timetracker.util.FileUtil;

public class TimeTracker {

    public static void main(String[] args) throws URISyntaxException, IOException {

        //Arrays.stream(args).forEach(System.out::println);

        ArgUtil argUtil=new ArgUtil();
        Args arguments=argUtil.parseArgs(args);


        //Get current task from file
        FileUtil fileUtil=new FileUtil();
        CurrentTask currentTask=fileUtil.getSavedTasks();


        switch(arguments.getCommand().name()){
            case "TASK_START" -> {
                
                Task task=new Task(arguments.getTaskName(),new Category(arguments.getCategoryName()));
                currentTask.startTask(task);
            }
            
            case "TASK_STOP" -> currentTask.completeTask(arguments.getTaskName());      

        };


        fileUtil.saveTasksToFile(currentTask);


    }
}




//To run with parameters
//& 'C:\Users\avish\.vscode\extensions\redhat.java-1.33.0-win32-x64\jre\17.0.11-win32-x86_64\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\avish\OneDrive\Desktop\java-proj-1\time-tracker\target\classes' 'com.avi.timetracker.TimeTracker' 'param1' 'param2' 'param3'
