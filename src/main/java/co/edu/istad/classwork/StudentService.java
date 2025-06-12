package co.edu.istad.classwork;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public void insertStudent(Student student) {
        students.add(student);
        System.out.println("[+] Inserting student: " + student);
    }

    public List<Student> selectStudents() {
        return students;
    }

    public Student selectStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean updateStudentById(int id, Student newStudent) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setFullName(newStudent.getFullName());
                student.setGender(newStudent.getGender());
                student.setScore(newStudent.getScore());
            }
            return true;
        }
        return false;
    }

    public boolean deleteStudentById(int id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
            }
            return true;
        }
        return false;
    }
}
