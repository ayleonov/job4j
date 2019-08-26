package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        int currentPriority = task.getPriority();
        if (tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                if (currentPriority < tasks.get(i).getPriority()) {
                    index = i;
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