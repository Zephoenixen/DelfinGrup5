public class DisciplineResult {
    final private DisciplineType discipline;
    final private int time;
    final private ResultType result;

    public DisciplineResult(DisciplineType d, int t, ResultType r){
        discipline = d;
        time = t;
        result = r;
    }

    public DisciplineType getDiscipline() {
        return discipline;
    }

    public int getTime() {
        return time;
    }

    public ResultType getResult() {
        return result;
    }
}
