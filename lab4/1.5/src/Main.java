// Создать класс Календарь с внутренним классом,
// с помощью объектов которого можно хранить информацию о выходных и праздничных днях.

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar("март", 2024);
        calendar.addDayOffList("8 марта", 2, 8, true);
        calendar.addDayOffList("суббота", 6, 3, false);
        calendar.addDayOffList("суббота", 6, 10, false);
        calendar.addDayOffList("воскресенье", 7, 4, false);
        calendar.addDayOffList("воскресенье", 7, 11, false);

        System.out.println(calendar);

        for(Calendar.DayOff dayOff: calendar.getDayOffList()) {
            System.out.println(dayOff);
        }
    }
}
