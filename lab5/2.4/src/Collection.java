import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Collection {
    private final Student[] students;

    public Collection(Student[] students) {
        this.students = students;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Student student: this.students) {
            result.append(student);
        }

        return String.valueOf(result);
    }

    public Collection getStudentsWithBadMarks() {
        Stream<Student> result = Arrays.stream(this.students).filter(Student::hasBadMarks);
        return new Collection(result.toArray(Student[]::new));
    }

    public Collection getStudentsWithAverageMarkAboveGiven(float mark) throws StudentException {
        if (mark < 0 || mark > 10) {
            throw new StudentException("Оценка должна быть больше 0 и меньше или равно 10");
        }

        Stream<Student> result = Arrays.stream(this.students).filter((s) -> s.getAverageMark() > mark);
        return new Collection(result.toArray(Student[]::new));
    }

    public Collection getStudentsWithMaxAverageMark(int count) throws StudentException {
        Stream<Student> result = Arrays.stream(this.students).sorted(Comparator.comparing(Student::getAverageMark).reversed()).limit(count);

        if (result.toArray(Student[]::new).length < count) {
            throw new StudentException("Студентов меньше заявленного числа");
        }

        return new Collection(result.toArray(Student[]::new));
    }

    public Collection getStudentsWithSemiPassingMark(int count) throws StudentException {
        Student[] sortedStudents = Arrays.stream(this.students).sorted(
                Comparator.comparing(Student::getAverageMark).reversed()
        ).toArray(Student[]::new);

        try {
            float semiPassingMark = sortedStudents[count].getAverageMark();
            Stream<Student> result = Arrays.stream(sortedStudents).filter((s) -> s.getAverageMark() == semiPassingMark);
            return new Collection(result.toArray(Student[]::new));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new StudentException("Указано слишком большое число");
        }
    }
}
