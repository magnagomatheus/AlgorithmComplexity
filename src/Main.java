//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    // Creating both types of ordered lists, by name and by registry.
    LinkedListWithComparator<Student> listOrderedName = new LinkedListWithComparator<Student>(true, new StudentComparatorByName());
    LinkedListWithComparator<Student> listOrderedRegistry = new LinkedListWithComparator<Student>(true, new StudentComparatorByRegistry());

    // Creating students
    Student s1 = new Student(1, "Ze", 12);
    Student s2 = new Student(2, "Mane", 12345);
    Student s3 = new Student(3, "Josep", 777);

    // Inserting students at the list ordered by name
    listOrderedName.insert(s1);
    listOrderedName.insert(s2);
    listOrderedName.insert(s3);

        // Inserting students at the list ordered by registry
    listOrderedRegistry.insert(s1);
    listOrderedRegistry.insert(s2);

    // Verifying if a student exists using the registry at the list ordered by registry
    listOrderedRegistry.elemExists(s1);
    listOrderedRegistry.elemExists(s2);

    // Searching a student at the list ordered by registry
    listOrderedRegistry.search(new Student(3, null, 0));
    // Searching a student at the list ordered by name
    listOrderedName.search(new Student(3, "Ze", 0));

    // Printing both lists
    System.out.println(listOrderedName);
    System.out.println(listOrderedRegistry);

    System.out.println("Test code wise");
    System.out.println("Test code wise2");
    System.out.println("groq test");

    }
}