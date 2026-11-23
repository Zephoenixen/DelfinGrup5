public class DisciplineResult {
    final private Discipline discipline;
    final private int time;

    public DisciplineResult(Discipline d, int t){
        discipline = d;
        time = t;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public int getTime() {
        return time;
    }

}
