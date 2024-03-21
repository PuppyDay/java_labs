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

    class DayOff {
        private final String name;
        private final int dayOfWeekNumber;

        DayOff(String name, int dayOfWeekNumber) {
            this.name = name;
            this.dayOfWeekNumber = dayOfWeekNumber;
        }
    }
}
