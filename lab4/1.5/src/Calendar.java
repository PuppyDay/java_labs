import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private final String month;
    private final int year;
    private List<DayOff> dayOffList;

    public Calendar(String month, int year) {
        this.month = month;
        this.year = year;
        this.dayOffList = new ArrayList<>();
    }

    public String toString() {
        return String.format(
                "Календарь за %s %d год, количество праздников и выходных: %d",
                this.month, this.year, this.dayOffList.size()
        );
    }

    public List<DayOff> getDayOffList() {
        return this.dayOffList;
    }

    public void addDayOffList(String name, int dayOfWeekNumber, int day, boolean isHoliday) {
        this.dayOffList.add(new DayOff(name, dayOfWeekNumber, day, isHoliday));
    }

    enum WeekDay {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY,
    }

    class DayOff {
        private final String name;
        private final int dayOfWeekNumber;
        private final int day;
        private final boolean isHoliday;

        DayOff(String name, int dayOfWeekNumber, int day, boolean isHoliday) {
            this.name = name;
            this.dayOfWeekNumber = dayOfWeekNumber;
            this.day = day;
            this.isHoliday = isHoliday;
        }

        public String toString() {
            if (this.isHoliday) {
                return String.format(
                        "Праздник %s %d числа (%s)",
                        this.name, this.day, WeekDay.values()[this.dayOfWeekNumber - 1]
                );
            }

            return String.format(
                    "Обычный выходной %d числа (%s)",
                    this.day, WeekDay.values()[this.dayOfWeekNumber - 1]
            );
        }
    }
}
