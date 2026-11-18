import java.time.LocalDate;
import java.time.Period;

public class Member {

    private final String name;
    private final LocalDate birthday;
    private final Address address;
    private final String email;
    private final MembershipType membershipType;

    private boolean active;
    private boolean hasPaid;

    public Member(String name, Address address,
                  String email, LocalDate birthday) {
        this(name, address, email, birthday, true);
    }

    public Member(String name, Address address,
                  String email, LocalDate birthday,
                  boolean active) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
        this.active = active;
        this.hasPaid = false;
        this.membershipType = CalculateMembership();
    }

    public int getAge() {
        return Period.between(
                birthday, LocalDate.now()
        ).getYears();
    }

    public MembershipType CalculateMembership() {
        int age = getAge();

        if (age < 18) {
            return MembershipType.JUNIOR;
        }

        if (age < 60) {
            return MembershipType.SENIOR;
        } else {
            return MembershipType.ELDERLY;
        }
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isActive() {
        return active;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}