// Создать класс Художественная Выставка с внутренним классом,
// с помощью объектов которого можно хранить информацию о картинах,
// авторах и времени проведения выставок.

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Exhibition exhibition1 = new Exhibition("Современное искусство", "Эрарта");
        Exhibition exhibition2 = new Exhibition("Классическое искусство", "Эрмитаж");

        exhibition1.addStructure(
                new String[]{"Черный квадрат", "Пейзаж", "Красный квадрат"},
                new String[]{"Малевич", "Кандинский"},
                LocalDate.parse("2024-03-03")
        );
        exhibition1.addStructure(
                new String[]{"Черный квадрат", "Красный квадрат"},
                new String[]{"Малевич"},
                LocalDate.parse("2024-03-10")
        );
        exhibition1.addStructure(
                new String[]{"Черный квадрат", "Пейзаж", "Подсолнухи"},
                new String[]{"Малевич", "Кандинский", "Ван Гог"},
                LocalDate.parse("2024-03-17")
        );

        exhibition2.addStructure(
                new String[]{"Три грации", "Союз земли и воды"},
                new String[]{"Рубенс"},
                LocalDate.parse("2024-03-11")
        );
        exhibition2.addStructure(
                new String[]{"Даная", "Три грации", "Возвращение блудного сына"},
                new String[]{"Рубенс", "Рембрант",},
                LocalDate.parse("2024-03-13")
        );

        System.out.println(exhibition1);
        System.out.println(exhibition2);
        System.out.println();

        System.out.println(exhibition1.getInfoAboutAllDates());
        System.out.println(exhibition2.getInfoAboutAllStructures());
        System.out.println(exhibition1.getInfoAboutStructure(LocalDate.parse("2024-03-10")));
    }
}
