import java.util.ArrayList;

public class Team {
    private TeamType teamType;
    private ArrayList<CompetitiveMember> teamMembers = new ArrayList<>();

    public Team(TeamType t){
        teamType = t;
    }

    public void addMember(CompetitiveMember m){
        teamMembers.add(m);
    }
}
