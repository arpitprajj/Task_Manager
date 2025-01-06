package com.example.demo.service;

import com.example.demo.entities.TaskEntity;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {

    @Getter
    private ArrayList<TaskEntity> tasks=new ArrayList<>();
    private int taskId=1;

    public TaskEntity addTask(String title,String description,String deadline){
        TaskEntity task=new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(new Date(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }
public ArrayList<TaskEntity>getTasks(){
        return tasks;
}
   public TaskEntity getTaskById(int id){
      // return tasks.stream().findAny().filter(task->task.getId()==id).orElse(null);
        for(TaskEntity task:tasks){
            if(task.getId()==id)
                return task;
        }
        return null;
    }
}
