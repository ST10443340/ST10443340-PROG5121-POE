
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testCheckTaskDescriptionSuccess() {
        Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription(), "Task description validation failed for valid input.");
    }

    @Test
    void testCheckTaskDescriptionFailure() {
        Task task = new Task("Login Feature", 
            "This description is way too long to be valid because it exceeds fifty characters", 
            "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription(), "Task description validation failed for invalid input.");
    }

    @Test
    void testCreateTaskID() {
        Task task = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        assertEquals("AD:1:Mik", task.createTaskID(), "Task ID generated incorrectly.");
    }

    @Test
   void testReturnTotalHours() {
        Task task = new Task("Task 1", "Short desc", "Dev 1", 5, "To Do");
        assertEquals(5, task.getTaskDuration(), "Total hours calculation failed."); // Updated method name
    }
    }


