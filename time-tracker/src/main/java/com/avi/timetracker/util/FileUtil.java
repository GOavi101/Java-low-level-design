package com.avi.timetracker.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.avi.timetracker.data.Category;
import com.avi.timetracker.data.CurrentTask;
import com.avi.timetracker.data.Task;
import com.avi.timetracker.data.TaskStatus;

public class FileUtil {

    public static final String PATH="task-info.csv";

    public CurrentTask getSavedTasks() throws URISyntaxException, IOException{

        Path path=Paths.get(PATH);
        
        if (Files.notExists(path)){
            Files.createFile(path);
        }
        Map<String, Task> taskMap = Files.lines(path) //reading line from file
                .map(line -> line.split(","))
                .filter(tokenArray -> tokenArray.length == 5)  //task has 5 params
                .map(tokenArray -> new Task(
                    tokenArray[0],  //taskName
                    new Category(tokenArray[1]), //category
                    tokenArray[2] == null || "null".equals(tokenArray[2]) || tokenArray[2].isBlank() ? null : LocalDateTime.parse(tokenArray[2]),//startTime
                    tokenArray[3] == null || "null".equals(tokenArray[3]) || tokenArray[3].isBlank() ? null : LocalDateTime.parse(tokenArray[3]),//endTime
                    TaskStatus.valueOf(tokenArray[4])//status
                )).collect(Collectors.toMap(Task::getTaskName, Function.identity())); // collecting as a map

        return new CurrentTask(taskMap);

    }

    public void saveTasksToFile(CurrentTask tasks) throws URISyntaxException, IOException{
        Path path=Paths.get(PATH);
        
        if (Files.notExists(path)){
            Files.createFile(path);
        }
        
        List<String> lines = tasks.getCurrentTasks()
                .values()   
                .stream()
                .map(Task::getCsvFormat)
                .toList();

        Files.write(path, lines);
    }

}
