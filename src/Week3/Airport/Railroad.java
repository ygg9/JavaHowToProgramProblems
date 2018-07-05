package Week3.Airport;

public class Railroad {

    private String region;
    private String city;
    private String state;
    private int zipCode;

    Railroad(){

    }

    public Railroad(String region, String city, String state, int zipCode) {
        this.region = region;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

}
