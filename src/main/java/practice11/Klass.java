package practice11;

import java.util.Observable;
import java.util.Observer;

public class Klass extends Observable {
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
            setChanged();
            notifyObservers(student.getName() + " become Leader of Class "+ number +".");
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public void appendMember(Student student) {
        student.joinKlass(this);
        setChanged();
        notifyObservers(student.getName() + " has joined Class "+ number +".");
    }
}
