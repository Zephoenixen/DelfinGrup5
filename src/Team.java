import java.util.ArrayList;

public class Team {
    private String teamName;
    private TeamType teamType;
    private DisciplineType disciplineType;
    private ArrayList<CompetitiveMember> teamMembers = new ArrayList<>();

    public Team(String n, TeamType t, DisciplineType d){
        teamName = n;
        teamType = t;
        disciplineType = d;
    }

    public void addMember(CompetitiveMember m){
        teamMembers.add(m);
    }





}
