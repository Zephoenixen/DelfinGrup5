import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitiveMember extends Member {
    private Discipline[] disciplines;
    private ArrayList<DisciplineResult> disciplineResult;
    private ArrayList<CompetitionResults> competitionResults;

    public CompetitiveMember(int memberNumber, String name, Address address, String email, int phoneNumber, LocalDate birthday, Discipline[] disciplines){
        super(memberNumber, name, address, email,phoneNumber, birthday);
        this.disciplines = disciplines;
        this.disciplineResult = new ArrayList<>();
        this.competitionResults = new ArrayList<>();
    }
}
