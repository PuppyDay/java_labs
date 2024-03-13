import java.util.Objects;

public class House {
    private final int number;
    private final String street;
    private final Door[] doors;
    private final Window[] windows;

    public House(int number, String street, Door[] doors, Window[] windows) {
        this.number = number;
        this.street = street;
        this.doors = doors;
        this.windows = windows;
    }

    public String toString() {
        return String.format("House number %d, street: %s.", this.number, this.street);
    }

    public boolean equals(Object o) {
        if (o instanceof House house) {
            return (Objects.equals(this.street, house.street)) && (this.number == house.number);
        }
        return false;
    }

    public int hashCode() {
        return String.format("%sh%d", this.street, this.number).hashCode();
    }

    public void print() {
        System.out.println(this);
    }

    public void lockWithKey() {
        for(Door door: this.doors) {
            door.lockWithKey();
        }
    }

    public void openWithKey() {
        for(Door door: this.doors) {
            door.openWithKey();
        }
    }

    public int getNumberOfWindows() {
        return this.windows.length;
    }

    public int getNumberOfDoor() {
        return this.doors.length;
    }

    public boolean isСlosed() {
        for (Door door: this.doors) {
            if (door.getIsOpen()) {
                return false;
            }
        }

        return true;
    }
}
