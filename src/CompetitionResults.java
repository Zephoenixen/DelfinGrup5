public class CompetitionResults extends DisciplineResult {
    final Competition competition;

    public CompetitionResults(DisciplineType d, int t, ResultType r, Competition c) {
        super(d, t, r);
        competition = c;
    }

}
