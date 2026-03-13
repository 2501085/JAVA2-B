public class Address {
    private String dosi;
    private String city;
    private String bunji;

    public String getDosi() {
        return dosi;
    }

    public void setDosi(String dosi) {
        this.dosi = dosi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBunji() {
        return bunji;
    }

    public void setBunji(String bunji) {
        this.bunji = bunji;
    }

    @Override
    public String toString() {
        return "Address{" +
                "dosi='" + dosi + '\'' +
                ", city='" + city + '\'' +
                ", bunji='" + bunji + '\'' +
                '}';
    }
}
