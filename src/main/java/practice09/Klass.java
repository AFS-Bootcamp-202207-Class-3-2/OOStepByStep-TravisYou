package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int classNumber;
    private Student leader;
    private List<Student> members;

    public Klass(int classNumber) {
        members = new ArrayList<Student>();
        this.classNumber = classNumber;
    }

    public int getNumber() {
        return this.classNumber;
    }

    public String getDisplayName() {
        return String.format("Class %d", this.classNumber);
    }

    public void assignLeader(Student student) {
        if(!this.members.contains(student)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = student;
    }

    public Student getLeader() {
        return this.leader;
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        members.add(student);
    }
}
