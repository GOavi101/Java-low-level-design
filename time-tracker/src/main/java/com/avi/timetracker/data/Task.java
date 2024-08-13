package com.avi.timetracker.data;

import java.time.LocalDateTime;

public class Task {

    private String taskName;
    private Category category;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private TaskStatus status;


    public Task(){

    }
    
    public Task(String taskName, Category category) {
        this.taskName = taskName;
        this.category = category;
        this.status=TaskStatus.IN_PROGRESS;
        this.startTime=LocalDateTime.now();
    }

    public Task(String taskName, Category category, LocalDateTime startTime, LocalDateTime endTime, TaskStatus status) {
        this.taskName = taskName;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }
    public String getTaskName() {
        return taskName;
    }
    public Category getCategory() {
        return category;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [taskName=" + taskName + ", category=" + category + ", startTime=" + startTime + ", endTime="
                + endTime + ", status=" + status + "]";
    }


}
