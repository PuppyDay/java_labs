// Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм
// для следующих классов: interface Mobile <- abstract class Siemens Mobile <- class Model.

public class Main {
    public static void main(String[] args) {
        Model model1 = new Model("Ультра", 2000, 8);
        Model model2 = new Model("Супер", 2003, 12);
        Model model3 = new Model("Про", 2004, 16);

        System.out.println(model1);
        System.out.println(model2);
        System.out.println(model3);

        model1.call("79999999999");
        model2.call("78888888888");
        model3.call("72222222222");

        model1.sendMessage();
        model2.sendMessage();
        model3.sendMessage();

        model1.takePhoto();
        model2.takePhoto();
        model3.takePhoto();
    }
}
