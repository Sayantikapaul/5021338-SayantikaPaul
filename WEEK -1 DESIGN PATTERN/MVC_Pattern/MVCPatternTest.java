package MVC_Pattern;

public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a student record
        Student student = new Student();
        student.setName("John Doe");
        student.setId("12345");
        student.setGrade("A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(student, view);

        // Display the initial student details
        controller.updateView();

        // Update the student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Display the updated student details
        controller.updateView();
    }
}