package thread;

/**
 * Created by Vivek Kumar Mishra on 04/07/2018.
 */
public enum Currency {
    USD(1.0), EUR(1.35), CAD(1.03), CHF(1.44), SEK(.55);

    public final double rate;

    Currency(double rate) {
        this.rate = rate;
    }
}
