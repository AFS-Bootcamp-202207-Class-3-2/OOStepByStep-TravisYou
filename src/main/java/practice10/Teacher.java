package practice10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> klasses;

    public Teacher(String name, int age) {
        super(name, age);
        this.klasses = new ArrayList<Klass>();
    }

    public Teacher(String name, int age, int classNumber) {
        super(name, age);
        this.klasses = new ArrayList<Klass>();
    }

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
        for(Klass klass : klasses) {
            klass.setTeacher(this);
        }
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public List<Klass> getClasses() {
        return klasses;
    }

    public boolean isTeaching(Student student) {
        for(Klass klass : klasses) {
            if(student.getKlass().getNumber() == klass.getNumber()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String introduce() {
        List<String> klassList;
        if(klasses != null && !klasses.isEmpty()) {
            klassList = klasses.stream()
                    .map(klass -> Integer.toString(klass.getNumber()))
                    .collect(Collectors.toList());
            return super.introduce() + " I am a Teacher. I teach Class " + String.join(", ", klassList) + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. I" + (!isTeaching(student) ? " don't" : "") + " teach " + student.getName() + ".";
    }

    public void knowLeader(Student student) {
        String teacherName = this.getName();
        String studentName = student.getName();
        int classNumber = student.getKlass().getNumber();
        System.out.printf("I am %s. I know %s become Leader of Class %d.\n", teacherName, studentName, classNumber);
    }

    public void knowMemberJoin(Student student) {
        String teacherName = this.getName();
        String studentName = student.getName();
        int classNumber = student.getKlass().getNumber();
        System.out.printf("I am %s. I know %s has joined Class %d.\n", teacherName, studentName, classNumber);
    }
}