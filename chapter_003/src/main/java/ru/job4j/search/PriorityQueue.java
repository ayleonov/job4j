package ru.job4j.search;

import java.util.LinkedList;


public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        int currentPriority = task.getPriority();
        if (tasks.size() > 0) {
            for (Task currentTask : tasks) {
                if (currentPriority < (currentTask.getPriority())) {
                    index = tasks.indexOf(currentTask);
                    break;
                }
            }

        }
        tasks.add(index, task);
    }

    public Task take() {

        return this.tasks.poll();
    }
}