package practice07;

public class Student extends Person {
    private Klass klass;

    public Student(String Name, int age, Klass klass) {
        super(Name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        return super.introduce() +  " I am a Student. I am at " + klass.getDisplayName() + ".";
    }
}

