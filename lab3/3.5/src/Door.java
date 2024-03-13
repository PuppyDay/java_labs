import java.util.Objects;

public class Door {
    private final int width;
    private final int height;
    private final String material;
    private final String color;
    private boolean isOpen = true;

    public Door() {
        this.width = 10;
        this.height = 100;
        this.material = "wood";
        this.color = "black";
    }

    public Door(int width, int height, String material, String color) {
        this.width = width;
        this.height = height;
        this.material = material;
        this.color = color;
    }

    public void lockWithKey() {
        this.isOpen = false;
    }

    public void openWithKey() {
        this.isOpen = true;
    }

    public String toString() {
        return String.format("Door (%dx%d), color: %s, material: %s.\n", this.width, this.height, this.color, this.material);
    }

    public boolean equals(Object o) {
        if (o instanceof Door door) {
            return (this.width == door.width)
                    && (this.height == door.height)
                    && (Objects.equals(this.material, door.material))
                    && (Objects.equals(this.color, door.color));
        }
        return false;
    }

    public int hashCode() {
        return String.format("%s%dx%d%s", this.material, this.width, this.height, this.color).hashCode();
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }
}
