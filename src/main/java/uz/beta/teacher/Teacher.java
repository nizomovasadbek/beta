package uz.beta.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.beta.util.Subject;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Teacher {

    private Integer teacherId;
    private String firstName;
    private String lastName;
    private List<Subject> subjects = new ArrayList<>();

    public Teacher(Integer id, String firstName, String lastName, Subject... subjs){
        teacherId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        for(Subject x:subjs){
            subjects.add(x);
        }
    }

    public void addSubjects(Subject sub){
        subjects.add(sub);
    }

    public void removeSubject(Subject sub){
        subjects.removeIf(pr -> sub.getSubjectId().equals(pr.getSubjectId()));
    }

    public void removeSubjectById(Integer id){
        subjects.removeIf(pr -> pr.getSubjectId().equals(id));
    }

}
