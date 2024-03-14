// Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм
// для следующих классов: interface Здание <- abstract class Общественное Здание <- class Театр.

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Theater theater1 = new Theater(
                "Большой театр",
                LocalTime.parse("09:00"),
                LocalTime.parse("21:00"),
                1000
        );
        Theater theater2 = new Theater(
                "Малый театр",
                LocalTime.parse("08:00"),
                LocalTime.parse("20:00"),
                200
        );
        System.out.println(theater1);
        System.out.println(theater2);

        theater1.displayOperatingTime();
        theater2.displayOperatingTime();

        theater1.openAllDoors();
        theater2.openAllDoors();

        theater1.buyTicket();
        theater1.buyTicket();
        theater1.buyTicket();

        theater2.buyTicket();
        theater2.buyTicket();
        theater2.buyTicket();
        theater2.buyTicket();

        System.out.println("В " + theater1 + " осталось билетов: " + theater1.getNumberOfTickets());
        System.out.println("В " + theater2 + " осталось билетов: " + theater2.getNumberOfTickets());

        theater1.closeAllDoors();
        theater2.closeAllDoors();
    }
}
