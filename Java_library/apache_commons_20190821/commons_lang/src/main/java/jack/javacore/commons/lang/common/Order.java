package jack.javacore.commons.lang.common;

public class Order {

    private Boolean guest;

    private String name;

    public Boolean getGuest() {
        return guest;
    }

    public void setGuest(Boolean guest) {
        this.guest = guest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "guest=" + guest +
                ", name='" + name + '\'' +
                '}';
    }
}
