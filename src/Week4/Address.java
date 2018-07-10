package Week4;

public class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private String postalCode;

    public Address(String name, String street, String city, String state, String postalCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
