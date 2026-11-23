public enum MembershipType {
    JUNIOR(1000),
    SENIOR(1600),
    ELDERLY(1200);

    private final double fee;

    MembershipType(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }
}
