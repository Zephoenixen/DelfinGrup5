import java.time.LocalDate;

public class CompetitiveMember extends Member {
    private String discipline;

    public CompetitiveMember(String name, Address address, String email, LocalDate birthday,String discipline){
        super(name, address, email, birthday);
        this.discipline=discipline;
    }
}
