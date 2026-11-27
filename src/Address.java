public class Address {
    private String streetName;
    private String houseNumber;
    private int postalCode;
    private String city;
    private String country;

    public Address(String streetName, String houseNumber, int postalCode, String city, String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreetName() {
        return streetName; }
    public String getHouseNumber() {
        return houseNumber; }
    public int getPostalCode() {
        return postalCode; }
    public String getCity() {
        return city; }
    public String getCountry() {
        return country; }

    @Override
    public String toString() {
        return streetName + " " + houseNumber + ", " + postalCode + " " + city;
    }
}