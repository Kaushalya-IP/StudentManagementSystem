public class Student {
    private String studentId;
    private String name;
    private int age;
    private double marks;

    public Student(String studentId, String name, int age, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + "\nName: " + name
                + "\nAge: " + age
                + "\nMarks: " + marks;
    }
}
