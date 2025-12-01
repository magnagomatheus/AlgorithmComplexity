import controller.StudentController;
import model.Student;

public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        
        // Creating students
        Student s1 = new Student(1, "Ze", 12);
        Student s2 = new Student(2, "Mane", 12345);
        Student s3 = new Student(3, "Josep", 777);
        
        // Adding students
        controller.addStudent(s1);
        controller.addStudent(s2);
        controller.addStudent(s3);
        
        // Checking if students exist
        controller.checkStudentExists(s1);
        controller.checkStudentExists(s2);
        
        // Searching students
        controller.searchStudentByRegistry(new Student(3, null, 0));
        controller.searchStudentByName(new Student(3, "Ze", 0));
        
        // Displaying lists
        controller.displayLists();
    }
}
