import java.time.LocalDate;
import java.util.ArrayList;

public class Club {

    private ArrayList<Member> members = new ArrayList<>();

    private ArrayList<Competition> competitions = new ArrayList<>();

    private TeamManager teamManager = new TeamManager();



    public void addMember(Member member) {
        members.add(member);
    }


    public ArrayList<Member> getMembers() {
        return members;
    }

    public Member findMember(int memberNumber) {
        int index = memberNumber - 1;

        if (index >= 0 && index < members.size()) {
            return members.get(index);
        }

        return null;
    }

    public boolean registerPayment(int memberNumber) {
        Member member = findMember(memberNumber);

        if (member != null) {
            member.setHasPaid(true);
            return true;
        }

        return false;
    }

    public ArrayList <Member> getUnpaidMembers() {
        ArrayList<Member> unpaidMembers = new ArrayList<>();

        for (Member member : members) {
            if (!member.hasPaid()) {
                unpaidMembers.add(member);
            }
        }

        return unpaidMembers;
    }

    public int calculateTotalIncome(LocalDate date) {
        FeeCalculator calculator = new FeeCalculator();
        int total = 0;

        for (Member member : members) {
            total += calculator.calculateFee(member, date);
        }

        return total;
    }

    private boolean addCompetition(Competition c){
        for (Competition competition: competitions){
            if (competition.equals(c)){ return false; }
        }
        competitions.add(c);
        return true;
    }

    public int nextMemberNumber(){
        int highestNumber = 0;
        for(Member member:members){
            if(member.getMemberID()>highestNumber){
                highestNumber = member.getMemberID();
            }
        }
        return highestNumber +1;
    }
}