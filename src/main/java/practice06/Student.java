package practice06;

import sun.dc.pr.PRError;

public class Student extends Person {
    private int classNumber = -1;
    private Klass klass;
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

    public String introduce() {
        return super.introduce() + String.format(" I am a Student. I am at Class %d.", this.classNumber);
    }
}