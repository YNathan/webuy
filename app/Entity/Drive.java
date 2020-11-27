package Entity;

/**
 * Created by jacky on 30/11/2017.
 */
public class Drive implements Comparable<Drive> {
    Long orderNumber;
    Date date;
    Double price;
    String originAddress;
    String destinationAddress;


    // Constructor's
    public Drive(Date date, Double price) {
        this.date = date;
        this.price = price;
    }

    public Drive(Long orderNumber, Date date, Double price) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.price = price;
    }

    public Drive(Long orderNumber, Date date, Double price, String originAddress, String destinationAddress) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.price = price;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
    }

    public Drive() {
    }


    // Getter's And Setter's

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }


    @Override
    public String toString() {
        return "Drive =>> ID: " + orderNumber + " " +
                date.toString() +
                ", \tprice: " + price +
                ", From: \t'"+originAddress+"' \t\t\t\t To: \t '"+destinationAddress+".";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drive drive = (Drive) o;

        if (date != null ? !date.equals(drive.date) : drive.date != null) return false;
        return price != null ? price.equals(drive.price) : drive.price == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Drive drive) {
        int nNumberToReturn = -1;
        if (this.getDate().isBiguer(drive.getDate())) {
            nNumberToReturn = 1;
        }
        return nNumberToReturn;
    }
}
