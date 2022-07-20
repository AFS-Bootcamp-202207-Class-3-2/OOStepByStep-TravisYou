package practice05;

public class Teacher extends Person {
    private int classNumber = -1;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int classNumber) {
        super(name, age);
        this.classNumber = classNumber;
    }

    public int getKlass() {
        return this.classNumber;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (this.classNumber != -1 ? String.format("Class %d.", this.classNumber) : "No Class.");
    }
}
