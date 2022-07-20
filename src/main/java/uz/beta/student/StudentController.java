package uz.beta.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('admin:write')")
    public String deleteStudent(@RequestParam("id") Integer id){
        studentService.deleteStudentById(id);
        String success = "True";
        return success;
    }

    @PutMapping("/edit/{studentId}")
    @PreAuthorize("hasAuthority('admin:write')")
    public String editStudent(@ModelAttribute Student student, @PathVariable("studentId")
                              Integer studentId){

        studentService.editStudent(student, studentId);

        String success = "True";
        return success;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:write')")
    public String addStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName")
                           String lastName, @RequestParam("role") String role, @RequestParam("age")
                           Integer age){
        Student temp = new Student();
        temp.setFirstName(firstName);
        temp.setLastName(lastName);
        temp.setRole(role);
        temp.setAge(age);

        studentService.saveStudent(temp);
        String success = "True";
        return success;
    }

    @GetMapping("/{studentId}")
    @PreAuthorize("hasAuthority('student:read')")
    public Student getStudentById(@PathVariable("studentId") Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('student:read')")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

}
