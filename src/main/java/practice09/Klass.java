package practice09;

public class Klass {
    private int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student student) {
        if(student.getKlass().getNumber() == number) {
            leader = student;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public void appendMember(Student student) {
        student.joinKlass(this);
    }
}
