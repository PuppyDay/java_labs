// Создать приложение, удовлетворяющее требованиям, приведенным в задании.
// Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить
// для каждого класса методы equals(), hashCode(), toString().
// Создать объект класса Простая дробь, используя класс Число.
// Методы: вывод на экран, сложение, вычитание, умножение, деление.

public class Main {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(1,2);
        Fraction fraction2 = new Fraction(3,4);
        Fraction fraction3 = new Fraction(6,12);
        Fraction fraction4 = new Fraction(42,56);
        Fraction fraction5 = new Fraction(3,4);

        System.out.println("Имеющиеся дроби:");
        System.out.println(fraction);
        System.out.println(fraction2);
        System.out.println(fraction3);
        System.out.println(fraction4);
        System.out.println(fraction5);

        System.out.println();

        System.out.println(fraction + " + " + fraction2 + " = " + fraction.sum(fraction2));
        System.out.println(fraction + " + " + fraction4 + " = " + fraction.sum(fraction4));

        System.out.println(fraction + " - " + fraction4 + " = " + fraction.sub(fraction4));
        System.out.println(fraction + " - " + fraction3 + " = " + fraction.sub(fraction3));

        System.out.println(fraction + " * " + fraction4 + " = " + fraction.mul(fraction4));
        System.out.println(fraction + " * " + fraction3 + " = " + fraction.mul(fraction3));

        System.out.println(fraction + " : " + fraction4 + " = " + fraction.division(fraction4));
        System.out.println(fraction + " : " + fraction3 + " = " + fraction.division(fraction3));

        System.out.println("hashCode для " + fraction + ": " + fraction.hashCode());
        System.out.println("hashCode для " + fraction2 + ": " + fraction2.hashCode());
        System.out.println("hashCode для " + fraction3 + ": " + fraction3.hashCode());
        System.out.println("hashCode для " + fraction4 + ": " + fraction4.hashCode());
        System.out.println("hashCode для " + fraction5 + ": " + fraction5.hashCode());

        System.out.println(fraction + " == " + fraction4 + " - " + fraction.equals(fraction4));
        System.out.println(fraction + " == " + fraction3 + " - " + fraction.equals(fraction3));
        System.out.println(fraction2 + " == " + fraction4 + " - " + fraction2.equals(fraction4));
        System.out.println(fraction2 + " == " + fraction5 + " - " + fraction2.equals(fraction5));
    }
}
