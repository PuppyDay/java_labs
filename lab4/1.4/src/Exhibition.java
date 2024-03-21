import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exhibition {
    private final String name;
    private final String place;
    private List<Structure> structures;

    public Exhibition(String name, String place) {
        this.name = name;
        this.place = place;
        this.structures = new ArrayList<>();
    }

    public String toString() {
        return String.format(
                "Выставка %s проходит в %s, количество событий %d",
                this.name, this.place, structures.size()
        );
    }

    public String getInfoAboutAllStructures() {
        StringBuilder result = new StringBuilder();
        for (Structure structure: this.structures) {
            result.append(structure).append("\n");
        }

        return result.toString();
    }

    public String getInfoAboutAllDates() {
        StringBuilder result = new StringBuilder("Выставка проводится в даты: ");
        for (Structure structure: this.structures) {
            result.append(structure.date.toString()).append(", ");
        }

        return result.toString();
    }

    public String getInfoAboutStructure(LocalDate date) {
        return Arrays.toString(this.structures.stream().filter((s) -> s.date.equals(date)).toArray());
    }

    public void addStructure(String[] paintings, String[] authors, LocalDate date) {
        this.structures.add(new Structure(paintings, authors, date));
    }

    class Structure {
        private final String[] paintings;
        private final String[] authors;
        private final LocalDate date;

        Structure(String[] paintings, String[] authors, LocalDate date) {
            this.paintings = paintings;
            this.authors = authors;
            this.date = date;
        }

        public String toString() {
            return String.format(
                    "Выставка %s числа, представлены картины: %s от авторов: %s",
                    this.date.toString(), Arrays.toString(this.paintings), Arrays.toString(this.authors)
            );
        }
    }
}
