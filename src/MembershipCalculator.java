import java.util.ArrayList;
public class MembershipCalculator {

    public double CalculateMembershipTotal(ArrayList<Member> members) {

        return members.stream()
                .filter(Member::isActive)
                .mapToDouble(member -> member.getMembershipType().getFee())
                .sum();
    }
}
