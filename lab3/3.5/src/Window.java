import java.util.Random;

public class Window {
    private final int width;
    private final int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Window() {
        Random r = new Random();
        this.width = r.nextInt() % 100;
        this.height = r.nextInt() % 100;
    }

    public String toString() {
        return String.format("Window (%dx%d).\n", this.width, this.height);
    }

    public boolean equals(Object o) {
        if (o instanceof Window window) {
            return (this.width == window.width) && (this.height == window.height);
        }
        return false;
    }

    public int hashCode() {
        return String.format("%dx%d", this.width, this.height).hashCode();
    }
}