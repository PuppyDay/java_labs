import java.util.HashMap;

public class Applicant {
    private final String lastName;
    private final String name;
    private final String patronymic;
    HashMap<String, HashMap<Subject, Integer>> examResults;

    public Applicant(String lastName, String name, String patronymic) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.examResults = new HashMap<>();
    }

    public String toString() {
        return String.format("Applicant %s %s %s", this.lastName, this.name, this.patronymic);
    }

    public String getExamResults(String facultyCode) {
        if (examResults.containsKey(facultyCode)) {
            StringBuilder result = new StringBuilder(String.format("Для факультета %s оценки: ", facultyCode));

            for (Subject subject: this.examResults.get(facultyCode).keySet()) {
                result.append(String.format("%s - %d, ", subject, this.examResults.get(facultyCode).get(subject)));
            }

            return String.valueOf(result);
        }

        return String.format("Для факультета %s нет оценок", facultyCode);
    }

    public void setExamResults(String facultyCode, Subject subject, int mark) {
        if (!examResults.containsKey(facultyCode)) {
            this.examResults.put(facultyCode, new HashMap<>());
        }

        this.examResults.get(facultyCode).put(subject, mark);
    }

    public float getAverageMark(String facultyCode) {
        if (examResults.containsKey(facultyCode)) {
            int sum = 0, count = 0;
            for (Subject subject: this.examResults.get(facultyCode).keySet()) {
                sum += this.examResults.get(facultyCode).get(subject);
                count +=1;
            }

            return (float) sum / count;
        }

        return 0f;
    }
}
