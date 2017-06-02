/**
 * Created by Shin on 2017-05-26.
 */
public class Event implements Loggable {
    MessageLogger logger;

    private String content;
    private long financialBenefit;
    private EffectOnPlayer effectOnPlayer;

    public Event(String content, long benefit, EffectOnPlayer effectOnPlayer) {
        this.content = content;
        this.financialBenefit = benefit;
        this.effectOnPlayer = effectOnPlayer;
    }

    public void affect(Team team, Player player) {
        affectBenefit(team);

        if(player != null && this.effectOnPlayer != null) {
            this.effectOnPlayer.affectHealthiness(player.getCondition());
            this.effectOnPlayer.affectPsychological(player.getCondition());
            this.effectOnPlayer.affectPlayerAvailability(player.getCondition());
        }
    }

    @Override
    public void setLogger(Object o) {
        if(o instanceof MessageLogger) {
            this.logger = (MessageLogger) o;
        }
    }
    @Override
    public void sendMessage(String msg) {
        this.logger.addMessage(msg);
    }

    private void affectBenefit(Team team) {
        team.setCapital(team.getCapital() + this.financialBenefit);
    }

    public String getContent() {
        return content;
    }

    public double getFinancialBenefit() {
        return financialBenefit;
    }

    public void setFinancialBenefit(long financialBenefit) {
        this.financialBenefit = financialBenefit;
    }

    public EffectOnPlayer getEffectOnPlayer() {
        return effectOnPlayer;
    }


}
