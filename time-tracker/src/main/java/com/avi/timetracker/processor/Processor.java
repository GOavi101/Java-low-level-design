package com.avi.timetracker.processor;

import com.avi.timetracker.data.Task;

public interface Processor {
    
    public void process(Task task);
}
