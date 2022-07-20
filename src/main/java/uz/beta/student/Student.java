package uz.beta.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student> {
    private Integer id;
    private String firstName;
    private String lastName;
    private String role;
    private int age;

    @Override
    public int compareTo(Student o) {
        if(id>o.getId()) return 1;
        if(id<o.getId()) return -1;
        return 0;
    }
}