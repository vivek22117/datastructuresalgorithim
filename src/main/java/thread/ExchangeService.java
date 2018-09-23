package thread;

/**
 * Created by Vivek Kumar Mishra on 21/07/2018.
 */
public class ExchangeService {

    public double exchangeCurrency(Currency source, Currency destination, double value){
        double rate = lookupExchangeRate(source, destination);
        return exchange(value, rate);
    }

    private double exchange(double value, double rate) {
        return Utils.round(value * rate);
    }

    public double lookupExchangeRate(Currency source, Currency destination) {
        return getRateWithDelay(source, destination);
    }

    private double getRateWithDelay(Currency source, Currency destination) {
        Utils.randomDelay();
        return source.rate / destination.rate;
    }
}
