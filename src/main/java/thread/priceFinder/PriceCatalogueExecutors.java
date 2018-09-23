package thread.priceFinder;

import thread.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Vivek Kumar Mishra on 21/07/2018.
 */
public class PriceCatalogueExecutors {
    private static final PriceFinder priceFinder = new PriceFinder();
    private final static Catalogue catalogue = new Catalogue();
    private final static ExchangeService exchangeService = new ExchangeService();

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new PriceCatalogueExecutors().findBestPrice(Currency.CHF, "Iphone 7");
    }

    private void findBestPrice(Currency chf, String productName) throws ExecutionException, InterruptedException {
        long time = System.currentTimeMillis();

        Future<Product> productFuture = executorService.submit(() -> catalogue.getProductByName(productName));
        Future<Price> priceFuture = executorService.submit(() -> priceFinder.findBestPrice(productFuture.get()));

        Future<Double> exchangeRate = executorService.submit(() -> exchangeService.lookupExchangeRate(Currency.USD, chf));

        double exchange = exchange(priceFuture.get(), exchangeRate.get());

        System.out.printf("A %s will cost us %f %s\n", productName, exchange, chf);
        System.out.printf("It took us %d ms to calculate this\n", System.currentTimeMillis() - time);

        executorService.shutdown();
    }

    private double exchange(Price price, Double aDouble) {
        return Utils.round(price.getPrice() * aDouble);
    }
}
