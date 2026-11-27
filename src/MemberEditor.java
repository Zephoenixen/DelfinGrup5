public class MemberEditor {
    public Member changeName(Member m, String name) {
        return new Member(
                name,
                m.getAddress(),
                m.getEmail(),
                m.getPhonenumber(),
                m.getBirthday(),
                m.getMemberID());
    }

    public Member changeAddress(Member m, Address address) {
        return new Member(
                m.getName(),
                address,
                m.getEmail(),
                m.getPhonenumber(),
                m.getBirthday(),
                m.getMemberID());

    }

    public Member changeEmail(Member m, String email) {
        return new Member(
                m.getName(),
                m.getAddress(),
                email,
                m.getPhonenumber(),
                m.getBirthday(),
                m.getMemberID());
    }

    public Member changeNumber(Member m, int number) {
        return new Member(
                m.getName(),
                m.getAddress(),
                m.getEmail(),
                number,
                m.getBirthday(),
                m.getMemberID());
    }
}
