package practice07;

public class Student extends Person {
    private int classNumber = -1;
    private Klass klass = null;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
        this.classNumber = klass.getNumber();
    }

    public Student(String name, int age, int classNumber) {
        super(name, age);
        this.classNumber = classNumber;
    }

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
        this.classNumber = klass.getNumber();
    }

    public Klass getKlass() {
        return this.klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a Student. I am %s Class %d.", (this.equals(this.getKlass().getLeader()) ? "Leader of" : "at"), this.classNumber);
    }
}