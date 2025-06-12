package co.edu.istad.classwork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InMemoryDatabase {

    @Bean
    public List<Student> students() {
        List<Student> students = new ArrayList(List.of(
                new Student(1, "Mata", "Male", 60),
                new Student(2, "Mekong", "Male", 88),
                new Student(3, "Kanika", "Female", 70),
                new Student(4, "Rothana", "Male", 50),
                new Student(5, "Mesang", "Male", 80),
                new Student(6, "Kukseng", "Male", 99),
                new Student(7, "Dara", "Male", 87),
                new Student(8, "Vanvan", "Male", 60),
                new Student(9, "Rotha", "Female", 80),
                new Student(10, "Minea", "Female", 76)
        ));
        return students;
    }
}
