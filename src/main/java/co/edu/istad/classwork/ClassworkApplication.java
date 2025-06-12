package co.edu.istad.classwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ClassworkApplication implements CommandLineRunner {

    private final StudentService studentService;

    public ClassworkApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClassworkApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("""
                \n======== Student Management System ========
                1. Display All Students
                2. Insert New Student
                3. Select Student by ID
                4. Update Student by ID
                5. Delete Student by ID
                6. Exit
                ------------------------------------------
                """);

            System.out.print("[+] Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.println("---- All Students ----");
                    List<Student> students = studentService.selectStudents();
                    students.forEach(System.out::println);
                }

                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Score: ");
                    double score = scanner.nextDouble();

                    studentService.insertStudent(new Student(id, fullName, gender, score));
                    System.out.println("✅ Student inserted.");
                }

                case 3 -> {
                    System.out.print("Enter ID to find: ");
                    int id = scanner.nextInt();
                    Student found = studentService.selectStudentById(id);
                    System.out.println(found != null ? found : "❌ Student not found.");
                }

                case 4 -> {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Full Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("New Score: ");
                    double score = scanner.nextDouble();

                    boolean updated = studentService.updateStudentById(id, new Student(id, name, gender, score));
                    System.out.println(updated ? "✅ Student updated." : "❌ Student not found.");
                }

                case 5 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = scanner.nextInt();
                    boolean deleted = studentService.deleteStudentById(id);
                    System.out.println(deleted ? "✅ Student deleted." : "❌ Student not found.");
                }

                case 6 -> {
                    System.out.println("👋 Exiting program...");
                    running = false;
                }

                default -> System.out.println("❗ Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
