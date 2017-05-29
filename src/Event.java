/**
 * Created by Shin on 2017-05-26.
 */
public class Event {
    private String content;
    private double financialBenefit;
    private EffectOnPlayer effectOnPlayer;

    public Event(String content, double benefit, EffectOnPlayer effectOnPlayer) {
        this.content = content;
        this.financialBenefit = benefit;
        this.effectOnPlayer = effectOnPlayer;
    }

    public void affectOnWholeTeam(Team team, Player player) {
        affectBenefit(team);

        if(this.effectOnPlayer != null) {
            this.effectOnPlayer.affectHealthiness(player.getCondition());
            this.effectOnPlayer.affectPsychological(player.getCondition());
            this.effectOnPlayer.affectPlayerAvailability(player.getCondition());
        }
    }

    private void affectBenefit(Team team) {
        team.setCapital(team.getCapital() + this.financialBenefit);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getFinancialBenefit() {
        return financialBenefit;
    }

    public void setFinancialBenefit(double financialBenefit) {
        this.financialBenefit = financialBenefit;
    }

    public EffectOnPlayer getEffectOnPlayer() {
        return effectOnPlayer;
    }

    public void setEffectOnPlayer(EffectOnPlayer effectOnPlayer) {
        this.effectOnPlayer = effectOnPlayer;
    }


}
