package model.comparator;

import model.Student;
import java.util.Comparator;

public class StudentComparatorByRegistry implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRegistry(), s2.getRegistry());
    }
}
