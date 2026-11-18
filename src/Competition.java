import java.time.LocalDate;

public class Competition {
    String compName;
    LocalDate date;
    String location;

    public Competition(String c, LocalDate d, String l){
        compName = c;
        date = d;
        location = l;
    }
}
