import java.time.LocalDate;
import java.time.Period;

public class FeeCalculator {

    public int calculateFee(Member member, LocalDate date) {

        if (!member.isActive()) {
            return 500;
        }

        int age = Period.between(
                member.getBirthday(), date
        ).getYears();

        if (age < 18) {
            return 1000;
        } else if (age > 60) {
            return 1200;
        } else {
            return 1600;
        }
    }
}