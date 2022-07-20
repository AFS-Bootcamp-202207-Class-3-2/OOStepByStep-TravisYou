package practice10;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observer {
    private final String PREFIX_OUTPUT_OF_UPDATE = "I am %s. I know %s ";
    private final List<String> TYPES = Arrays.asList(new String[]{"NEW_LEADER", "NEW_MEMBER"});
    private final String[] END_OUTPUT_OF_UPDATE = {"become Leader of Class %d.\n", "has joined Class %d.\n"};
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

    @Override
    public void update(Observable o, Object arg) {
        Student student = (Student) ((Pair)arg).getKey();
        String type = (String) ((Pair)arg).getValue();
        String teacherName = this.getName();
        String studentName = student.getName();
        int classNumber = student.getKlass().getNumber();
        int indexOfType = TYPES.indexOf(type);
        String s = String.format(PREFIX_OUTPUT_OF_UPDATE + END_OUTPUT_OF_UPDATE[indexOfType], teacherName, studentName, classNumber);
        System.out.printf(s);
    }
}