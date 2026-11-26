import java.time.LocalDate;
import java.time.Period;

public class Member {
    private final int memberNumber;
    private String name;
    private LocalDate birthday;
    private Address address;
    private int phoneNumber;
    private String email;
    //private MembershipType membershipType;
    private boolean active;
    private boolean hasPaid;

    public Member(int memberNumber, String name, Address address, String email, int phoneNumber, LocalDate birthday) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        //this.membershipType = CalculateMembership();
        this.active = true;
        this.hasPaid = true;
    }

    public int getAge() {
        return getAge(LocalDate.now());
//        return Period.between(birthday, LocalDate.now()).getYears();
    }
    public int getAge(LocalDate date){
        return Period.between(birthday, date).getYears();
    }

//    public MembershipType CalculateMembership() {
//        int age = getAge();
//        if (!active) {
//            return MembershipType.PASSIVE;
//        }
//        if (age < 18) {
//            return MembershipType.JUNIOR;
//        }
//        if (age < 60) {
//            return MembershipType.SENIOR;
//        } else {
//            return MembershipType.ELDERLY;
//        }
//    }

    public int getMemberNumber() {
        return memberNumber;
    }

//    public MembershipType getMembershipType() {
//        return membershipType;
//    }
    public MembershipType getMembershipType(){
        return getMembershipType(LocalDate.now());
    }
    public MembershipType getMembershipType(LocalDate date){
        if(!active){
            return MembershipType.PASSIVE;
        }
        int age = getAge(date);
        if(age<18){
            return MembershipType.JUNIOR;
        }
        if (age<60){
            return MembershipType.SENIOR;
        }
        else{
           return MembershipType.ELDERLY;
        }
    }

    public String getName() {
        return name;
    }

    public double getMembershipFee() {
        return getMembershipType().getFee();
//        return membershipType.getFee();
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "#" + memberNumber + " | " + name +
                "\n Address: " + address +
                "\n Email: " + email + "| TLF:" + phoneNumber +
        "\n Type: " + getMembershipType(LocalDate.now()) + " (Aktiv: " + active + ")";
    }
}