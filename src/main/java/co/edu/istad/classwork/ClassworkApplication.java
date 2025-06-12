package co.edu.istad.classwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassworkApplication implements CommandLineRunner {
    private final StudentService studentService;

    public ClassworkApplication(StudentService studentService) {
        this.studentService = studentService;
    }
    public static void main(String[] args)  {
        SpringApplication.run(ClassworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("======>>> Starting ClassworkApplication <<<========");

        System.out.println("[+] INSERTING STUDENTS");
            studentService.insertStudent(new Student(11, "Martin", "Male", 70));

        System.out.println("==============> SELECTING STUDENT LISTS <=================");
        studentService.selectStudents().forEach(System.out::println);

        System.out.println("==============> SELECTING STUDENT BY ID <===============");
        System.out.println(studentService.selectStudentById(1));;

        System.out.println("==============> UPDATING STUDENT BY ID <===============");
        boolean updated = studentService.updateStudentById(2, new Student(2,"Matra", "Male", 99));
        System.out.println("Student updated: " + updated);
        System.out.println("Student details: " + studentService.selectStudentById(2));

        System.out.println("==============> DELETING STUDENT BY ID <===============");
        boolean deleted = studentService.deleteStudentById(1);
        System.out.println("Student deleted: " + deleted);
    }
}
