/**
 * Created by Shin on 2017-05-26.
 */
public class Director extends Unit {
    private int age;
    private String nationality;

    public Director(String name, long salary, int age, String nationality) {
        super(name, salary);

        this.age = age;
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }
}
