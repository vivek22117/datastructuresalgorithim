package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vivek Kumar Mishra on 21/07/2018.
 */
public class FaultyExchangeService {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public double exchange(double price , double rate){
        return Utils.round(price * rate);
    }

    public CompletableFuture<Double> lookupExchangeRateAsync(Currency source, Currency dest){
        CompletableFuture<Double> result = new CompletableFuture<>();

        if(Math.random() < 0.7){
            result.completeExceptionally(new TimeoutException("Couldn't connect to exchange service"));
        }

        executorService.submit(() -> {
            result.complete(getRateWithDelay(source, dest));
        });
        return result;
    }

    public double lookupExchangeRateWithoutException(Currency source, Currency destination) {
        return getRateWithDelay(source, destination);
    }

    private Double getRateWithDelay(Currency source, Currency dest) {
        Utils.randomDelay();
        return source.rate / dest.rate;
    }
}
