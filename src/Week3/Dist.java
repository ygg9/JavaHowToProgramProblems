package Week3;

public enum Dist {
    DC1("Raleigh", "DC1"), DC2("Kansas City", "DC2"), DC3("Denver", "DC3"), NA("", "");

    private String city;
    private String DC;

    public String getCity() {
        return city;
    }

    public String getDC() {
        return DC;
    }

    Dist(String city, String DC) {
        this.city = city;
        this.DC = DC;
    }
}
