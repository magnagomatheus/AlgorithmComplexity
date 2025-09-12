public class Student implements Comparable<Student> {
    private String name;
    private int registry;
    private int grade;

    // Default constructor
    public Student(int r, String n, int g) {
        this.name = n;
        this.registry = r;
        this.grade = g;
    }


    // Getters and Setters of student's name and registry.
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public int getRegistry() {return this.registry;}
    public void setRegistry(int registry) {this.registry = registry;}

    @Override
    public String toString() {
        return Integer.toString(this.registry) + " - " + this.name;
    }

    @Override
    public boolean equals(Object a) {
        if(a instanceof Student) return this.registry == ((Student)a).registry;
        else return false;
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }
}
