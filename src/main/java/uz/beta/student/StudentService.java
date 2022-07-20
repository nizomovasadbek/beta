package uz.beta.student;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    private void initService(){
        students.add(new Student(0, "Rohl", "Genre", "", 19));
        students.add(new Student(1,"Ken", "Thompson", "", 21));
        students.add(new Student(2,"Alisa", "Lopes", "", 18));
        students.add(new Student(3,"Raul", "Juan", "", 20));
    }

    public void saveStudent(Student student){
        Collections.sort(students);
        int max = students.get(students.size()-1).getId();
        max++;
        student.setId(max);
        students.add(student);
    }

    public void editStudent(Student student, Integer id){
        students.removeIf(st -> id.equals(st.getId()));
        students.add(student);
    }

    public Student getStudentById(Integer id){
        return students.stream()
                .filter(st -> id.equals(st.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't found"));
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public void deleteStudentById(Integer id){
        //TODO: return function boolean variable
        students.removeIf(per -> id.equals(per.getId()));
    }

}
