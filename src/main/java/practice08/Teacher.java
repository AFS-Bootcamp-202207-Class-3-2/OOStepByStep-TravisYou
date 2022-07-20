package practice08;

public class Teacher extends Person {
    private int classNumber = -1;
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int classNumber) {
        super(name, age);
        this.classNumber = classNumber;
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
        this.classNumber = klass.getNumber();
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
        this.classNumber = klass.getNumber();
    }

    public Klass getKlass() {
        return this.klass;
    }

    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (this.classNumber != -1 ? String.format("Class %d.", this.classNumber) : "No Class.");
    }

    public String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. I" + (this.classNumber != student.getKlass().getNumber() ? " don't" : "") + " teach " + student.getName() + ".";
    }
}