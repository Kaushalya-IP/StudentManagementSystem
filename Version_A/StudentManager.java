import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println("--------------------");
                System.out.println(student);
            }
        }
    }
    public void searchStudent(String studentId) {
        boolean found = false;

        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                System.out.println("\nStudent found:");
                System.out.println("--------------------");
                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
    public void updateStudent(String studentId, String newName, int newAge, double newMarks) {
        boolean found = false;

        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                student.setName(newName);
                student.setAge(newAge);
                student.setMarks(newMarks);

                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
    public void deleteStudent(String studentId) {
        boolean found = false;

        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
    public void calculateAverageMarks() {
        if (students.isEmpty()) {
            System.out.println("No students found. Cannot calculate average.");
        } else {
            double total = 0;

            for (Student student : students) {
                total = total + student.getMarks();
            }

            double average = total / students.size();

            System.out.println("Average marks: " + average);
        }
    }
}
