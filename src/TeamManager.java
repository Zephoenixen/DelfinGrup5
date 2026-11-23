public class TeamManager {
    private Team juniorTeam;
    private Team seniorTeam;

    public TeamManager(){
        juniorTeam = new Team(TeamType.JUNIOR);
        seniorTeam = new Team(TeamType.SENIOR);
    }
}
