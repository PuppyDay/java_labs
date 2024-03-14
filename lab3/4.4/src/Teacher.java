import java.util.Random;

public class Teacher {

    private final String lastName;
    private final String name;
    private final String patronymic;

    public Teacher(String lastName, String name, String patronymic) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String toString() {
        return String.format("Teacher %s %s %s", this.lastName, this.name, this.patronymic);
    }

    public void gradeExam(Subject subject, Applicant applicant, String facultyCode) {
        int mark = new Random().nextInt() % 5;
        applicant.setExamResults(facultyCode, subject, Math.abs(mark) + 1);
    }
}

