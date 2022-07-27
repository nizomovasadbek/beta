package uz.beta.teacher;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static uz.beta.util.Subject.*;

@Service
public class TeacherService {

    private List<Teacher> teachers = new ArrayList<>();

    @PostConstruct
    private void initService(){
        teachers.add(new Teacher(1, "Anna", "Johnson", CALCULUS, LINEAR_ALGEBRA, DIFFERENTIAL_EQUATIONS));
        teachers.add(new Teacher(2, "Jimmy", "Stephson", HISTORY));
        teachers.add(new Teacher(3, "Clara", "Mattphew", PHILOSOPHY, HISTORY));
        teachers.add(new Teacher(4, "Rahymond", "Wick", PROGRAMMING));
    }
}
