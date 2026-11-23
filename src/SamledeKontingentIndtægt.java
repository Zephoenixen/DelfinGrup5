import java.util.ArrayList;
public class SamledeKontingentIndtægt {

    public double beregnForventetIndtægt(ArrayList<Member> members) {

        return members.stream()
                .filter(Member::isActive)
                .mapToDouble(member -> member.getMembershipType().getFee())
                .sum();
    }
}
