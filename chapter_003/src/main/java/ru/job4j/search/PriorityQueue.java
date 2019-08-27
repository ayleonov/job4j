package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    ListIterator iterator = tasks.listIterator();
    Task currentTask;

    public void put(Task task) {
        int index = 0;
        int currentPriority = task.getPriority();
        if (tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                for (Task currentTask : tasks)
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