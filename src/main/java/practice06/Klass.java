package practice06;

public class Klass {
    private int classNumber;

    public Klass(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getNumber() {
        return this.classNumber;
    }

    public String getDisplayName() {
        return String.format("Class %d", this.classNumber);
    }
}
