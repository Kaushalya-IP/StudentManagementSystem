import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            displayMenu();
            choice = readMenuChoice(scanner);

            switch (choice) {
                case 1:
                    addStudent(scanner, manager);
                    break;

                case 2:
                    System.out.println("\n===== STUDENT LIST =====");
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    manager.searchStudent(scanner.nextLine());
                    break;

                case 4:
                    updateStudent(scanner, manager);
                    break;

                case 5:
                    System.out.print("Enter student ID to delete: ");
                    manager.deleteStudent(scanner.nextLine());
                    break;

                case 6:
                    manager.calculateAverageMarks();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
            }

        } while (choice != 7);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Calculate Average Marks");
        System.out.println("7. Exit");
    }

    public static int readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            }

            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    public static int readValidAge(Scanner scanner) {
        while (true) {
            System.out.print("Enter student age: ");

            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                scanner.nextLine();

                if (age > 0 && age <= 120) {
                    return age;
                }

                System.out.println("Age must be between 1 and 120.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }

    public static double readValidMarks(Scanner scanner) {
        while (true) {
            System.out.print("Enter student marks: ");

            if (scanner.hasNextDouble()) {
                double marks = scanner.nextDouble();
                scanner.nextLine();

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println("Marks must be between 0 and 100.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static void addStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int age = readValidAge(scanner);
        double marks = readValidMarks(scanner);

        Student student = new Student(id, name, age, marks);
        manager.addStudent(student);
    }

    public static void updateStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();

        int newAge = readValidAge(scanner);
        double newMarks = readValidMarks(scanner);

        manager.updateStudent(id, newName, newAge, newMarks);
    }
}