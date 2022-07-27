package uz.beta.util;

public enum Subject {
    CALCULUS(1),
    ENGLISH(2),
    PHILOSOPHY(3),
    LINEAR_ALGEBRA(4),
    DIFFERENTIAL_EQUATIONS(5),
    HISTORY(6),
    PROGRAMMING(7),
    PHYSICS(8),
    ACADEMIC_WRITING(9);

    private Integer subjectId;

    Subject(Integer id){
        subjectId = id;
    }

    public Integer getSubjectId(){
        return subjectId;
    }
}
