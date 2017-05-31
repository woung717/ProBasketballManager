import java.sql.Connection;

/**
 * Created by Shin on 2017-05-26.
 */

public class Player extends Unit {
    private int age;
    private String nationality;
    private String position;
    private float height;

    private Condition condition = null;
    private int skill;

    public Player(String name, long salary, int age, String nationality, String position, float height, int skill) {
        super(name, salary);

        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.height = height;
        this.skill = skill;
    }

    public int getTotalSkill() {
        // 선수의 능력치(condition.healthiness, condition.psychological, skill)를 합하여 반환

        return index; // 반환되는 변수로 바꿀것
    }

    public int shoot() {
        int point = 0; // 2점 혹은 3점 (랜덤) Math.random()
        // getTotalSkill 값을 0~1.0사이의 값으로 스케일링 하여(x 0.01) + 0.5 를 더하고 (point / 2 x 0.1) 을 더해서
        // TrueFalse 로 득점 유무 - 득점시 point 못하면 point = 0
        return point; // 반환되는 변수로 바꿀것
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public float getHeight() {
        return height;
    }

    public Condition getCondition() {
        return condition;
    }

    public int getSkill() {
        return skill;
    }
}