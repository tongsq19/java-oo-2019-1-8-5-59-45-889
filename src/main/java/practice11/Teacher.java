package practice11;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Teacher extends Person implements Observer {
    private LinkedList<Klass> classes;

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.classes = linkedList;
        for(int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i).addObserver(this);
        }
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.classes = null;
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    public String introduce() {
        if (classes == null) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            int i = 0;
            StringBuilder s = new StringBuilder();
            for(; i<classes.size()-1; i++)
                s.append(classes.get(i).getNumber()).append(", ");
            s.append(classes.get(i).getNumber()).append(".");

            return super.introduce() + " I am a Teacher. I teach Class " + s.toString();
        }
    }

    public boolean isTeaching(Student student) {
        return classes.indexOf(student.getKlass()) > -1;
    }

    public String introduceWith(Student student) {
        if(isTeaching(student)) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("I am "+ getName() + ". I know " + arg);
    }
}

