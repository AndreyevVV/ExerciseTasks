package LeetCode.Daily_Challenge.Medium.Design_Task_Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    
    static class TaskManager {

        static class Task {
            int userId, taskId, priority, version;
            Task(int userId, int taskId, int priority, int version) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
                this.version = version;
            }
        }

        private static class Info {
            int userId, priority, version;
            Info(int userId, int priority, int version) {
                this.userId = userId;
                this.priority = priority;
                this.version = version;
            }
        }

        private Map<Integer, Info> taskMap;
        private PriorityQueue<Task> pq;
        private int counter;

        public TaskManager(List<List<Integer>> tasks) {
            taskMap = new HashMap<>();
            pq = new PriorityQueue<>((a, b) -> {
                if (b.priority != a.priority) return b.priority - a.priority;
                if (b.taskId != a.taskId) return b.taskId - a.taskId;
                return b.version - a.version;
            });
            counter = 0;

            for (List<Integer> t : tasks) {
                add(t.get(0), t.get(1), t.get(2));
            }
        }

        public void add(int userId, int taskId, int priority) {
            int ver = ++counter;
            taskMap.put(taskId, new Info(userId, priority, ver));
            pq.offer(new Task(userId, taskId, priority, ver));
        }

        public void edit(int taskId, int newPriority) {
            Info old = taskMap.get(taskId);
            if (old != null) {
                int ver = ++counter;
                taskMap.put(taskId, new Info(old.userId, newPriority, ver));
                pq.offer(new Task(old.userId, taskId, newPriority, ver));
            }
        }

        public void rmv(int taskId) {
            taskMap.remove(taskId);
        }

        public int execTop() {
            while (!pq.isEmpty()) {
                Task top = pq.poll();
                Info current = taskMap.get(top.taskId);
                if (current != null && current.priority == top.priority && current.version == top.version) {
                    taskMap.remove(top.taskId);
                    return top.userId;
                }
            }
            return -1;
        }
    }
}
