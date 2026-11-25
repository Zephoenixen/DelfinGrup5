public class TeamManager {
    private Team juniorTeam;
    private Team seniorTeam;

    public TeamManager(){
        juniorTeam = new Team(TeamType.JUNIOR);
        seniorTeam = new Team(TeamType.SENIOR);
    }

    public boolean addMember(CompetitiveMember member){
        if(member == null) { return false; }

        //maybe return if duplicate person, or relegate that logic to member creation.

        if(member.getAge() < 18){
            juniorTeam.addMember(member);
        }
        else {
            seniorTeam.addMember(member);
        }
        return true;
    }
}
