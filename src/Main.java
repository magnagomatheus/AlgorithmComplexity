//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    LinkedListWithComparator<Student> listOrderedName = new LinkedListWithComparator<Student>(true, new StudentComparatorByName());
    LinkedListWithComparator<Student> listOrderedRegistry = new LinkedListWithComparator<Student>(true, new StudentComparatorByRegistry());

    Student s1 = new Student(1, "Ze", 12);
    Student s2 = new Student(2, "Mane", 12345);
    Student s3 = new Student(3, "Josep", 777);

    listOrderedName.insert(s1);
    listOrderedName.insert(s2);
    listOrderedName.insert(s3);

    listOrderedRegistry.insert(s1);
    listOrderedRegistry.insert(s2);

    listOrderedRegistry.elemExists(s1);
    listOrderedRegistry.elemExists(s2);

    listOrderedRegistry.search(new Student(3, null, 0));
    listOrderedName.search(new Student(3, "Ze", 0));

    System.out.println(listOrderedName);
    System.out.println(listOrderedRegistry);
    }
}