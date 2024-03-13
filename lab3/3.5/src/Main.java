// Создать приложение, удовлетворяющее требованиям, приведенным в задании.
// Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить
// для каждого класса методы equals(), hashCode(), toString().
// Создать объект класса Дом, используя классы Окно, Дверь.
// Методы: закрыть на ключ, вывести на консоль количество окон, дверей.

public class Main {
    public static void main(String[] args) {
        House house = new House(10, "3 гражданская",
                new Door[]{new Door(), new Door()},
                new Window[] {
                        new Window(), new Window(),
                        new Window(10, 30), new Window(10, 30)
        });
        House house2 = new House(10, "3 гражданская",
                new Door[]{new Door(), new Door()},
                new Window[] {
                        new Window(), new Window(),
                        new Window(10, 30), new Window(10, 30)
                });
        House house3 = new House(15, "Краснобогатырская",
                new Door[]{new Door()},
                new Window[]{new Window(), new Window()}
        );

        System.out.println(house);
        System.out.println("Количество окон: " + house.getNumberOfWindows() + ", количество дверей: " + house.getNumberOfDoor());
        System.out.println("hashCode = " + house.hashCode());
        System.out.println();

        System.out.println(house2);
        System.out.println("Количество окон: " + house2.getNumberOfWindows() + ", количество дверей: " + house2.getNumberOfDoor());
        System.out.println("hashCode = " + house2.hashCode());
        System.out.println();

        System.out.println(house3);
        System.out.println("Количество окон: " + house3.getNumberOfWindows() + ", количество дверей: " + house3.getNumberOfDoor());
        System.out.println("hashCode = " + house3.hashCode());
        System.out.println();

        System.out.println("Закрываем дом на ключ.");
        house.lockWithKey();
        System.out.println("Дом закрыт: " + house.isСlosed());
        System.out.println();

        System.out.println("Открываем дом ключом.");
        house.openWithKey();
        System.out.println("Дом закрыт: " + house.isСlosed());
    }
}
