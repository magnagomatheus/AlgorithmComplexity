package controller;

import model.Student;
import model.LinkedListWithComparator;
import model.comparator.StudentComparatorByName;
import model.comparator.StudentComparatorByRegistry;
import view.StudentView;

public class StudentController {
    private LinkedListWithComparator<Student> listOrderedByName;
    private LinkedListWithComparator<Student> listOrderedByRegistry;
    private StudentView view;
    
    public StudentController() {
        this.listOrderedByName = new LinkedListWithComparator<>(true, new StudentComparatorByName());
        this.listOrderedByRegistry = new LinkedListWithComparator<>(true, new StudentComparatorByRegistry());
        this.view = new StudentView();
    }
    
    public void addStudent(Student student) {
        listOrderedByName.insert(student);
        listOrderedByRegistry.insert(student);
    }
    
    public void checkStudentExists(Student student) {
        boolean exists = listOrderedByRegistry.elemExists(student);
        view.displayExistsResult(exists);
    }
    
    public void searchStudentByRegistry(Student student) {
        Student found = listOrderedByRegistry.search(student);
        view.displaySearchResult(found, found != null);
    }
    
    public void searchStudentByName(Student student) {
        Student found = listOrderedByName.search(student);
        view.displaySearchResult(found, found != null);
    }
    
    public void displayLists() {
        view.displayList(listOrderedByName, "List ordered by name");
        view.displayList(listOrderedByRegistry, "List ordered by registry");
    }
    
    public void displayMessage(String message) {
        view.displayMessage(message);
    }
}
