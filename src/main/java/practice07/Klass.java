package practice07;

public class Klass {
    private int classNumber;
    private Student leader;

    public Klass(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getNumber() {
        return this.classNumber;
    }

    public String getDisplayName() {
        return String.format("Class %d", this.classNumber);
    }

    public void assignLeader(Student student) {
        this.leader = student;
    }

    public Student getLeader() {
        return this.leader;
    }
}
