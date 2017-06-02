/**
 * Created by Shin on 2017-05-26.
 */
public class Database {
    String[] scheduleDB = {"No", "No", "League", "No", "League", "No", "No",
                            "No", "No", "Exhibition", "No", "No", "No", "Exhibition",
                            "No", "Exhibition", "No", "No", "League", "No", "No",
                            "No", "League", "No", "No", "Exhibition", "No", "No",
                            "No", "Exhibition",
                            "No", "No", "No", "No", "No", "League", "No",
                            "No", "Exhibition", "No", "No", "League", "No", "No",
                            "Exhibition", "League", "No", "Exhibition", "No", "No", "No",
                            "No", "League", "No", "No", "No", "League", "No",
                            "No", "No", "No",
                            "No", "No", "Exhibition", "Exhibition", "No", "No", "No",
                            "No", "No", "No", "No", "Exhibition", "No", "No",
                            "Exhibition", "No", "Exhibition", "No", "No", "Exhibition", "No",
                            "No", "Exhibition", "No", "Exhibition", "No", "No", "No",
                            "No", "No" };

    String[][] teamDB = {{"Los Angeles Lakers", "Los Angeles", "Pro"}, {"Chicago Bulls", "Chicago", "Pro"},
                            {"Real Madrid Baloncesto", "Madrid", "Pro"}, {"KGC Insamgongsa", "Anyang", "Pro"},
                            {"Georgia Stars 15U", "Atlanta", "Amature"}};

    String[] nationDB = {"USA", "Europe", "Asia"};

    Tactic[] tacticDB = {new Tactic("Balance", 5, 5),
                        new Tactic("Aggressive", 7, 2),
                        new Tactic("Defensive", 3, 6)};

    Event[] eventDB = {new Event(" got banned because of using illegal drug. Fine : $5000", -5000, new EffectOnPlayer(0, -1, false)),
                                new Event(" want to leave the team.", 0, new EffectOnPlayer(0, -2, true)),
                                new Event(" is arrested because of drunken drive.", 0, new EffectOnPlayer(0, -2, true)),
                                new Event(" fought with rival team member.", 0, new EffectOnPlayer(-2, -3, true)),
                                new Event(" got MVP of this season. Team reward : $500,000", 500000, new EffectOnPlayer(0, 3, true)),
                                new Event("Someone donation enormous amount of money. Donation : $1,000,000", 1000000, null),
                                new Event("Tax evasion is revealed by the media. Fine : $100,000", -100000, null),
                                new Event("Got invest from the billionare. Investment : $10,000,000", 10000000, null)
                                };

    Staff[] staffDB = { new Staff("Manuel Coker", 5400, new EffectOnPlayer(3, 0, true)),
                        new Staff("Nelson Fairchild", 5600, new EffectOnPlayer(0, 3, true)),
                        new Staff("John Riley", 5900, new EffectOnPlayer(0, 1, true)),
                        new Staff("Carl Pfeffer", 4600, new EffectOnPlayer(1, 0, true)),
                        new Staff("Nathan Fields", 5400, new EffectOnPlayer(0, 3, true)),
                        new Staff("Phillip Crom", 5000, new EffectOnPlayer(0, 1, true)),
                        new Staff("Robert Hansen", 4500, new EffectOnPlayer(1, 0, true)),
                        new Staff("Neil Barns", 5200, new EffectOnPlayer(2, 0, true)),
                        new Staff("David Haskins", 5900, new EffectOnPlayer(0, 2, true)),
                        new Staff("Horace Saavedra", 4900, new EffectOnPlayer(2, 0, true)),
                        new Staff("Nicholas Salazar", 4900, new EffectOnPlayer(2, 0, true)),
                        new Staff("Larry Beaty", 5700, new EffectOnPlayer(0, 2, true)),
                        new Staff("Arthur Mcminn", 4800, new EffectOnPlayer(1, 0, true)),
                        new Staff("Enrique Lunt", 5600, new EffectOnPlayer(3, 0, true)),
                        new Staff("Sam Mcmullen", 4500, new EffectOnPlayer(0, 2, true)),
                        new Staff("Timothy Sotto", 5600, new EffectOnPlayer(0, 2, true)),
                        new Staff("David Merrell", 5900, new EffectOnPlayer(3, 0, true)),
                        new Staff("Samuel Paar", 5800, new EffectOnPlayer(0, 2, true)),
                        new Staff("Bryan Stroud", 5100, new EffectOnPlayer(0, 3, true)),
                        new Staff("Samuel Brandt", 5500, new EffectOnPlayer(0, 3, true)),
                        new Staff("Andrew Johnson", 5400, new EffectOnPlayer(0, 2, true)),
                        new Staff("Gilberto Rankin", 5300, new EffectOnPlayer(3, 0, true)),
                        new Staff("Samuel Olenick", 4500, new EffectOnPlayer(2, 0, true)),
                        new Staff("Lance Crain", 5700, new EffectOnPlayer(3, 0, true)),
                        new Staff("Jose Huber", 4900, new EffectOnPlayer(1, 0, true)) };

    Player[] playersDB = {new Player("Christopher Parrales", 7500, 28, "Europe", "Center", 205, 5),
            new Player("James Barnes", 3000, 24, "USA", "Guard", 197, 2),
            new Player("Jack Eley", 8000, 24, "USA", "Forward", 188, 4),
            new Player("Robert Delmont", 4200, 28, "USA", "Center", 195, 2),
            new Player("Jason Liriano", 5200, 31, "USA", "Guard", 205, 2),
            new Player("Joshua Schopp", 5700, 24, "USA", "Forward", 207, 3),
            new Player("Daryl Mcadoo", 6000, 31, "USA", "Center", 202, 3),
            new Player("Daniel Higginbotham", 3000, 30, "Europe", "Guard", 196, 2),
            new Player("Richard Finkelstein", 9600, 26, "USA", "Forward", 185, 4),
            new Player("John Wright", 4400, 24, "Europe", "Center", 189, 2),
            new Player("Tyrone Sprauve", 3000, 24, "Europe", "Guard", 206, 2),
            new Player("Dwayne Bader", 6400, 31, "USA", "Forward", 191, 4),
            new Player("Thomas Abad", 3800, 27, "Europe", "Center", 198, 2),
            new Player("Marshall Campbell", 12500, 27, "Europe", "Guard", 204, 5),
            new Player("Gaston Frank", 6800, 29, "Europe", "Forward", 191, 4),
            new Player("Ray Jones", 7200, 26, "USA", "Center", 185, 4),
            new Player("Jason Muncy", 6800, 25, "Europe", "Guard", 193, 4),
            new Player("Brandon Holmes", 5700, 24, "Europe", "Forward", 203, 3),
            new Player("Darryl Streit", 6300, 29, "Europe", "Center", 205, 3),
            new Player("Scott Moeller", 3000, 30, "USA", "Guard", 200, 2),
            new Player("Sebastian Hardiman", 3200, 28, "USA", "Forward", 200, 2),
            new Player("David Piper", 8800, 24, "USA", "Center", 187, 4),
            new Player("Carl Pringle", 3800, 27, "Europe", "Guard", 196, 2),
            new Player("Joseph Salyards", 12500, 25, "Europe", "Forward", 201, 5),
            new Player("Charles Benton", 6600, 26, "Europe", "Center", 191, 3),
            new Player("Manuel Prestwich", 8000, 26, "USA", "Guard", 185, 5),
            new Player("Jason Martin", 7800, 28, "USA", "Forward", 201, 3),
            new Player("Francisco Muzzarelli", 5700, 30, "Europe", "Center", 206, 3),
            new Player("Moises Horne", 8400, 28, "USA", "Guard", 209, 4),
            new Player("Alden Sims", 7600, 31, "Europe", "Forward", 195, 4),
            new Player("Richard Getter", 9500, 30, "Europe", "Center", 191, 5),
            new Player("Robert Thorsness", 10500, 29, "USA", "Guard", 186, 5),
            new Player("Dean Collins", 12500, 25, "Europe", "Forward", 201, 5),
            new Player("Bobby Fedezko", 6300, 26, "Europe", "Center", 202, 3),
            new Player("Roman Lehman", 11000, 26, "USA", "Guard", 198, 5),
            new Player("Michael Parker", 5100, 26, "USA", "Forward", 205, 3),
            new Player("Thomas Arnold", 11500, 29, "USA", "Center", 195, 5),
            new Player("Jared Ahrens", 7600, 31, "Europe", "Guard", 201, 4),
            new Player("Andrew Kocher", 6000, 30, "Europe", "Forward", 189, 3),
            new Player("William Correll", 10000, 25, "Europe", "Center", 192, 4),
            new Player("Mike Markarian", 9200, 28, "Europe", "Guard", 192, 4),
            new Player("William Hudson", 6400, 27, "Europe", "Forward", 208, 4),
            new Player("William Morrill", 9000, 31, "USA", "Center", 185, 5),
            new Player("Michael Dugas", 4600, 25, "USA", "Guard", 198, 2),
            new Player("Fred Carlson", 3800, 27, "Europe", "Forward", 202, 2),
            new Player("Jack Howard", 7600, 25, "Europe", "Center", 186, 4),
            new Player("Timothy Lamb", 6300, 27, "USA", "Guard", 187, 3),
            new Player("Owen Rasset", 6000, 28, "Europe", "Forward", 195, 3),
            new Player("Clifford Quintanilla", 4800, 25, "USA", "Center", 196, 2),
            new Player("Brian Rice", 7500, 24, "USA", "Guard", 188, 5),
            new Player("Steven Perales", 10500, 25, "USA", "Forward", 209, 5),
            new Player("Matt Anderson", 10500, 30, "Europe", "Center", 193, 5),
            new Player("William Aucoin", 5400, 24, "Europe", "Guard", 205, 3),
            new Player("Casey Forry", 4500, 27, "USA", "Forward", 207, 3),
            new Player("Alan Wallace", 6400, 29, "USA", "Center", 205, 4),
            new Player("Eliseo Walker", 4200, 24, "Europe", "Guard", 185, 2),
            new Player("Daniel Hampton", 9500, 24, "USA", "Forward", 191, 5),
            new Player("Clay Wells", 5000, 31, "USA", "Center", 204, 2),
            new Player("William Hill", 3600, 28, "USA", "Guard", 199, 2),
            new Player("Tim Harvey", 10000, 27, "Europe", "Forward", 204, 5)};

    // Singleton Object Initializer

    private static Database instance;
    private Database() {};

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public String[][] getTeamDB() {
        return teamDB;
    }

}
