import java.time.LocalTime;

interface IBuilding {
    public abstract void closeAllDoors();
    public abstract void openAllDoors();
}

abstract class PublicBuilding implements IBuilding {
    protected final String name;
    protected final LocalTime startTime;
    protected final LocalTime endTime;
    protected final int maximumCapacity;
    protected boolean allDoorsOpened;

    PublicBuilding(String name, LocalTime startTime, LocalTime endTime, int maximumCapacity) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maximumCapacity = maximumCapacity;
    }

    public abstract void displayOperatingTime();
    public abstract String toString();

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public boolean getAllDoorsOpened() {
        return this.allDoorsOpened;
    }

    public String getName() {
        return this.name;
    }

    public void closeAllDoors() {
        this.allDoorsOpened = false;
        System.out.println("Все двери закрыты");
    }

    public void openAllDoors() {
        this.allDoorsOpened = true;
        System.out.println("Все двери открыты");
    }
}

public class Theater extends PublicBuilding {
    private int numberOfTickets;
    Theater(String name, LocalTime startTime, LocalTime endTime, int maximumCapacity) {
        super(name, startTime, endTime, maximumCapacity);
        numberOfTickets = 100;
    }

    public int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    public void buyTicket() {
        numberOfTickets -= 1;
        System.out.printf("Билет куплен, осталось %d\n", this.numberOfTickets);
    }

    @Override
    public void displayOperatingTime() {
        System.out.printf("Время работы театра: c %s по %s\n", this.startTime.toString(), this.endTime.toString());
    }

    @Override
    public String toString() {
        return String.format("Театр %s", this.name);
    }
}
