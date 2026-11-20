import java.time.LocalDate;

public class CompetitiveMember extends Member {
    private Discipline discipline;
    private DisciplineResult disciplineResult;
    private CompetitionResults competitionResults;

    public CompetitiveMember(String name, Address address, String email, int phoneNumber, LocalDate birthday, Discipline discipline){
        super(name, address, email,phoneNumber, birthday);
        this.discipline=discipline;
        this.disciplineResult =
        this.competitionResults = ;

    }
}
