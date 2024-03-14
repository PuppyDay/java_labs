// Построить модель программной системы.
// Система Вступительные экзамены. Абитуриент регистрируется на Факультет, сдает Экзамены.
// Преподаватель выставляет Оценку.
// Система подсчитывает средний балл и определяет Абитуриентов, зачисленных в учебное заведение.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Создали два факультета
        Faculty facultyOfComputerScience = new Faculty(
                "Computer Science", "CS1",
                new Subject[] {Subject.INFORMATICS, Subject.MATHEMATICS}, 2,
                new Teacher[]{
                        new Teacher("Иванов", "Иван", "Иванович"),
                        new Teacher("Петров", "Петр", "Петрович"),
                        new Teacher("Сидоров", "Семен", "Семенович")
                }
        );
        Faculty facultyOfPhysics = new Faculty(
                "Physics", "Ph1",
                new Subject[] {Subject.PHYSICS, Subject.MATHEMATICS}, 1,
                new Teacher[]{
                        new Teacher("Иванова", "Анна", "Ивановна"),
                        new Teacher("Петрова", "Алина", "Андреевна")
                }
        );

        Applicant applicant1 = new Applicant("Третьяков", "Иван", "Игоревич");
        Applicant applicant2 = new Applicant("Алексеева", "Анна", "Романовна");
        Applicant applicant3 = new Applicant("Касаткин", "Никита", "Максимович");
        Applicant applicant4 = new Applicant("Новикова", "Алиса", "Тимофеевна");
        Applicant applicant5 = new Applicant("Иванов", "Ян", "Максимович");

        // Зарегистрировались на факультеты
        facultyOfComputerScience.register(applicant1);
        facultyOfComputerScience.register(applicant2);
        facultyOfComputerScience.register(applicant3);

        facultyOfPhysics.register(applicant3);
        facultyOfPhysics.register(applicant4);
        facultyOfPhysics.register(applicant5);

        System.out.println("Студенты на факультетах:");
        System.out.println(facultyOfComputerScience.getInformationAboutApplicants());
        System.out.println(facultyOfPhysics.getInformationAboutApplicants());

        // Сдача экзаменов
        facultyOfComputerScience.passExam(Subject.INFORMATICS, applicant1);
        facultyOfComputerScience.passExam(Subject.MATHEMATICS, applicant1);

        facultyOfComputerScience.passExam(Subject.INFORMATICS, applicant2);
        facultyOfComputerScience.passExam(Subject.MATHEMATICS, applicant2);

        facultyOfComputerScience.passExam(Subject.INFORMATICS, applicant3);
        facultyOfComputerScience.passExam(Subject.MATHEMATICS, applicant3);

        facultyOfPhysics.passExam(Subject.PHYSICS, applicant3);
        facultyOfPhysics.passExam(Subject.MATHEMATICS, applicant3);

        facultyOfPhysics.passExam(Subject.PHYSICS, applicant4);
        facultyOfPhysics.passExam(Subject.MATHEMATICS, applicant4);

        facultyOfPhysics.passExam(Subject.PHYSICS, applicant5);
        facultyOfPhysics.passExam(Subject.MATHEMATICS, applicant5);

        // Вывод результатов экзаменов для студентов по факультетам
        System.out.println("Результаты экзаменов:");
        System.out.println(applicant1 + ": " + applicant1.getExamResults(facultyOfComputerScience.getCode()));
        System.out.println(applicant2 + ": " + applicant2.getExamResults(facultyOfComputerScience.getCode()));
        System.out.println(applicant3 + ": " + applicant3.getExamResults(facultyOfComputerScience.getCode()));

        System.out.println(applicant3 + ": " + applicant3.getExamResults(facultyOfPhysics.getCode()));
        System.out.println(applicant4 + ": " + applicant4.getExamResults(facultyOfPhysics.getCode()));
        System.out.println(applicant5 + ": " + applicant5.getExamResults(facultyOfPhysics.getCode()));

        // Определение зачисленных абитуриентов
        System.out.println("\nЗачисленные абитуриенты:");
        System.out.println(facultyOfComputerScience + ": " + Arrays.toString(facultyOfComputerScience.determinationOfAdmittedApplicants()));
        System.out.println(facultyOfPhysics + ": " + Arrays.toString(facultyOfPhysics.determinationOfAdmittedApplicants()));
    }
}
