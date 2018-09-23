package thread;

import java.util.concurrent.*;

/**
 * Created by Vivek Kumar Mishra on 29/08/2018.
 */
public class AsyncFaultyExchangeService {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public double exchange(double value, double rate){
        return Utils.round(value * rate);
    }

    public CompletableFuture<Double> lookUpExchangeRateAsyncCall(Currency source, Currency destination){
        CompletableFuture<Double> result = new CompletableFuture<>();
        if(Math.random() < 0.7){
            result.completeExceptionally(new TimeoutException("Not able to connect to exchange service"));
        }

        executorService.submit(() -> result.complete(getDelayRate(source, destination)));

        return result;
    }

    private Double getDelayRate(Currency source, Currency destination) {
        Utils.randomDelay();
        return source.rate/destination.rate;
    }
}
