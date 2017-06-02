public class Main {
    static Schedule schedule;
    static Database gameDB;
    static Interation console;

    static Director director;
    static Team[] teams;

    static MessageLogger logger;

    static int teamIndex;

    public static void main(String[] args) {
        logger = new MessageLogger();

        gameDB = Database.getInstance();

        console = Interation.getInstance(gameDB, teams[teamIndex]);
        console.setLogger(logger);

        director = console.directorSetting();
        teamIndex = console.chooseTeam();

        initialize();

        schedule = Schedule.getInstance(teams, teamIndex, gameDB.eventDB, gameDB.scheduleDB);
        schedule.setLogger(logger);

        while(schedule.proceedDay()) {
            boolean loop = true;

            while(loop) {
                int select = console.printMainMenu();

                switch (select) {
                    case 1:
                        console.showTeamInformation();

                        break;
                    case 2:
                        console.showDirectorInformation();

                        break;
                    case 3: {
                        int[] changes = console.showPlayerChange();
                        teams[teamIndex].changePlayer(changes[1], changes[0]);

                        break;
                    }
                    case 4: {
                        int[] changes = console.showStaffChange();
                        teams[teamIndex].changeStaff(changes[1], changes[0]);

                        break;
                    }
                    case 5: {
                        int tactic = console.showTactics();
                        teams[teamIndex].setTactic(gameDB.tacticDB[tactic % gameDB.tacticDB.length]);

                        break;
                    }
                    case 6: {
                        loop = false;

                        break;
                    }
                    default:
                        break;
                }
            }
        }

    }

    public static void initialize() {
        teams = new Team[gameDB.getTeamDB().length];

        for(int i = 0; i < teams.length; i++) {
            teams[i] = new Team(gameDB.teamDB[i][0], gameDB.teamDB[i][1], gameDB.teamDB[i][2]);

            if(i == teamIndex) teams[i].setDirector(director);

            int perTeamPlayer = gameDB.playersDB.length / teams.length;
            for(int j = 0; j < perTeamPlayer; j++) {
                gameDB.playersDB[i * perTeamPlayer + j].setLogger(logger);
                gameDB.playersDB[i * perTeamPlayer + j].setCondition(new Condition());
                if(j < 5) {
                    teams[i].getPlayers().add(gameDB.playersDB[i * perTeamPlayer + j]);
                } else {
                    teams[i].getPlayersPool().add(gameDB.playersDB[i * perTeamPlayer + j]);
                }
            }

            int perTeamStaff = gameDB.staffDB.length / teams.length;
            for(int j = 0; j < perTeamStaff; j++) {
                if(j < 3) {
                    teams[i].getStaffs().add(gameDB.staffDB[i * perTeamStaff + j]);
                    teams[i].updateStaffEffect(gameDB.staffDB[i * perTeamStaff + j], 1);
                } else {
                    teams[i].getStaffPool().add(gameDB.staffDB[i * perTeamStaff + j]);
                }
            }

            teams[i].setTactic(gameDB.tacticDB[RandomGenerator.getRangedRandomInt(0, gameDB.tacticDB.length - 1)]);
            teams[i].setCapital(Double.valueOf((Math.random() * 10) % 9 * 1000000).longValue());
        }
    }
}
