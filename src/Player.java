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

        return (this.getCondition().getHealthiness() + this.getCondition().getPsychological() + this.skill);
    }

    public int shoot() {
        boolean temp = true;
        int point = (int)(Math.random() * 2 + 2); // 2점 혹은 3점 (랜덤) Math.random()
        // getTotalSkill 값을 0~1.0사이의 값으로 스케일링 하여(x 0.01) + 0.5 를 더하고 (point / 2 x 0.1) 을 더해서
        // TrueFalse 로 득점 유무 - 득점시 point 못하면 point = 0
        float prob = (float)(this.getTotalSkill() * 0.01) + 0.5 + (point / 2 * 0.1);
        if(ProbabilityGenerator.TrueFalse(temp,prob))
          point = 0;

        return point; 
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
