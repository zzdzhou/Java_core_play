package jack.javacore.commons.lang.common;

public class OrderDTO {

    private String name;

    private Boolean guest;

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
        return "OrderDTO{" +
                "name='" + name + '\'' +
                ", guest=" + guest +
                '}';
    }
}
