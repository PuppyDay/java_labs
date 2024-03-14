interface IMobile {
    public abstract void call(String number);
    public abstract void takePhoto();
    public abstract void sendMessage();
}

abstract class SiemensMobile implements IMobile {
    protected final String name;
    protected final int year;
    protected final int ram;

    SiemensMobile(String name, int year, int ram) {
        this.name = name;
        this.year = year;
        this.ram = ram;
    }

    public String toString() {
        return String.format(
                "Мобильный телефон Siemens, модель %s, год выпуска %d, (RAM %d)",
                this.name, this.year, this.ram
        );
    }
}

public class Model extends SiemensMobile {

    Model(String name, int year, int ram) {
        super(name, year, ram);
    }

    @Override
    public void call(String number) {
        System.out.printf("Bell.. Bell.. Звоню на номер %s с телефона %s\n", number, this.name);
    }

    @Override
    public void takePhoto() {
        System.out.printf("Делаю красивое фото с телефона %s\n", this.name);
    }

    @Override
    public void sendMessage() {
        System.out.printf("Отправляю сообщение с телефона %s\n",this.name);
    }
}
