import java.util.*;

public class Faculty {
    private final String name;
    private final String code;
    private final Subject[] subjects;
    private final int totalNumberOfStudents;
    private final Teacher[] teachers;
    private List<Applicant> applicants;

    public Faculty(String name, String code, Subject[] subjects, int totalNumberOfStudents, Teacher[] teachers) {
        this.name = name;
        this.code = code;
        this.subjects = subjects;
        this.totalNumberOfStudents = totalNumberOfStudents;
        this.teachers = teachers;
        this.applicants = new ArrayList<>();
    }

    public String toString() {
        return String.format("Faculty %s (%s)", this.name, this.code);
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public Subject[] getSubjects() {
        return this.subjects;
    }

    public List<Applicant> getApplicants() {
        return this.applicants;
    }

    public int getTotalNumberOfStudents() {
        return this.totalNumberOfStudents;
    }

    public Teacher[] getTeachers() {
        return this.teachers;
    }

    public void register(Applicant applicant) {
        this.applicants.add(applicant);
    }

    public void passExam(Subject subject, Applicant applicant) {
        int randomTeacher = new Random().nextInt(this.teachers.length);
        this.teachers[randomTeacher].gradeExam(subject, applicant, this.code);
    }

    public Applicant[] determinationOfAdmittedApplicants() {
        return this.applicants.stream().sorted(new Comparator<Applicant>() {
            public int compare(Applicant a1, Applicant a2) {
                return Float.compare(a1.getAverageMark(code), a2.getAverageMark(code));
            }
        }.reversed()
        ).limit(this.totalNumberOfStudents).toArray(Applicant[]::new);
    }

    public String getInformationAboutApplicants() {
        StringBuilder result = new StringBuilder(String.format("Students by %s: \n", this));

        for (Applicant applicant: this.applicants) {
            result.append(applicant).append("\n");
        }

        return String.valueOf(result);
    }
}
