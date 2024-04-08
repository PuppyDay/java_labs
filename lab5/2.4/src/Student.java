import java.util.Arrays;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phone;
    private int[] marks;

    public Student() {}

    public Student(int id, String lastName, String firstName, String patronymic, String address, String phone, int[] marks) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.marks = marks;
    }

    public String toString() {
        return String.format(
                "Student(%d) %s %s %s.\tAddress: %s.\tPhone: %s.\tMarks: %s\n",
                this.id, this.lastName, this.firstName, this.patronymic, this.address, this.phone,
                Arrays.toString(this.marks)
        );
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int[] getMarks() {
        return this.marks;
    }

    public boolean hasBadMarks(){
        for(int mark: this.marks) {
            if (mark < 4) {
                return true;
            }
        }

        return false;
    }

    public float getAverageMark() {
        return (float) Arrays.stream(this.marks).sum() / this.marks.length;
    }
}

class StudentException extends Exception {
    public StudentException(String message) {
        super(message);
    }
}
