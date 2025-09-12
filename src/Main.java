//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    LinkedList<Student> l = new LinkedList<Student>();
    Student s1 = new Student(1, "zé", 50);
    Student s2 = new Student(2, "Mane", 50);
    l.insert(s1);
    l.insert(s2);
    System.out.println(l);

    }
}