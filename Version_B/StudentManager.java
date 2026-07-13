import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student existingStudent : students) {
            if (existingStudent.getStudentId().equalsIgnoreCase(student.getStudentId())) {
                System.out.println("Student ID already exists. Please use a different ID.");
                return;
            }
        }

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
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                System.out.println("\nStudent found:");
                System.out.println("--------------------");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void updateStudent(String studentId, String newName, int newAge, double newMarks) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                student.setName(newName);
                student.setAge(newAge);
                student.setMarks(newMarks);
                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void deleteStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equalsIgnoreCase(studentId)) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void calculateAverageMarks() {
        if (students.isEmpty()) {
            System.out.println("No students found. Cannot calculate average.");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getMarks();
        }

        double average = total / students.size();
        System.out.printf("Average marks: %.2f%n", average);
    }
}
