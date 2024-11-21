import java.util.*;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void populateTestData() {
        tasks.add(new Task("Create Reports", "Mike Smith", "Samantha Paulson", "Done", 5, 10));
        tasks.add(new Task("Create Login", "Mike Smith", "Samantha Paulson", "In Progress", 3, 7));
        tasks.add(new Task("Glenda Oberholzer", "Glenda Oberholzer", "John Doe", "Done", 7, 12));
    }

    public String displayDoneTasks() {
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            if ("Done".equals(task.getStatus())) {
                result.append(task.getName()).append("\n");
            }
        }
        return result.toString();
    }

    public String displayLongestTask() {
        Task longestTask = null;
        for (Task task : tasks) {
            if (longestTask == null || task.getDuration() > longestTask.getDuration()) {
                longestTask = task;
            }
        }
        return longestTask != null ? longestTask.getName() : "";
    }

    public String searchTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                return task.getDeveloper();
            }
        }
        return "Task not found";
    }

    public String searchTasksByDeveloper(String developer) {
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            if (task.getDeveloper().equals(developer)) {
                result.append(task.getName()).append("\n");
            }
        }
        return result.toString();
    }

    public void deleteTaskByName(String name) {
        tasks.removeIf(task -> task.getName().equals(name));
    }

    public String displayReport() {
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            result.append(task.getName()).append("\n");
        }
        return result.toString();
    }
}
