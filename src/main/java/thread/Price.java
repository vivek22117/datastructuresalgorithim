package thread;

/**
 * Created by Vivek Kumar Mishra on 04/07/2018.
 */
public class Price {

    private Currency currency;
    private double price;

    public Price(Currency currency, double price) {
        this.currency = currency;
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price1 = (Price) o;

        if (Double.compare(price1.price, price) != 0) return false;
        return currency == price1.currency;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency != null ? currency.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency=" + currency +
                ", price=" + price +
                '}';
    }
}
