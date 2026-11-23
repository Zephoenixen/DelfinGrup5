public class CompetitionResults extends DisciplineResult {
    final Competition competition;

    public CompetitionResults(Discipline d, int t, Competition c) {
        super(d, t);
        competition = c;
    }

}
