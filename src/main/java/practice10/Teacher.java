package practice10;

import java.util.LinkedList;

public class Teacher extends Person{
    private LinkedList<Klass> classes;

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.classes = linkedList;
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
}
