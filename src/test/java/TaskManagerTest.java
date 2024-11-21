import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
        taskManager.populateTestData();
    }

    @Test
    public void testDoneTasks() {
        // Check if tasks with status "Done" are displayed correctly
        String result = taskManager.displayDoneTasks();
        assertTrue(result.contains("Create Reports"));
    }

    @Test
    public void testLongestTaskDuration() {
        // Check if the task with the longest duration is correctly identified
        String result = taskManager.displayLongestTask();
        assertTrue(result.contains("Glenda Oberholzer"));
    }

    @Test
    public void testSearchTaskByName() {
        // Search for a task by its name
        String result = taskManager.searchTaskByName("Create Login");
        assertTrue(result.contains("Mike Smith"));
    }

    @Test
    public void testSearchTasksByDeveloper() {
        // Search for tasks assigned to a specific developer
        String result = taskManager.searchTasksByDeveloper("Samantha Paulson");
        assertTrue(result.contains("Create Reports"));
    }

    @Test
    public void testDeleteTask() {
        // Test deletion of a task
        taskManager.deleteTaskByName("Create Reports");
        String result = taskManager.displayReport();
        assertFalse(result.contains("Create Reports"));
    }

    @Test
    public void testDisplayReport() {
        // Ensure the report lists all tasks correctly
        String result = taskManager.displayReport();
        assertTrue(result.contains("Create Login"));
    }
}
