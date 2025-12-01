package view;

import model.Student;
import model.LinkedListWithComparator;

public class StudentView {
    
    public void displayStudent(Student student) {
        if(student != null) {
            System.out.println("Student: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }
    
    public void displayList(LinkedListWithComparator<Student> list, String listName) {
        System.out.println(listName + ": " + list);
    }
    
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void displaySearchResult(Student student, boolean found) {
        if(found && student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found in the list.");
        }
    }
    
    public void displayExistsResult(boolean exists) {
        if(exists) {
            System.out.println("Student exists in the list.");
        } else {
            System.out.println("Student does not exist in the list.");
        }
    }
}
