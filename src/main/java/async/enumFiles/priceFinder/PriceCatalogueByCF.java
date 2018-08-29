package async.enumFiles.priceFinder;

import async.enumFiles.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static async.enumFiles.Currency.USD;

/**
 * Created by Vivek Kumar Mishra on 29/08/2018.
 */
public class PriceCatalogueByCF {

    private final Catalogue catalogue = new Catalogue();
    private final PriceFinder priceFinder = new PriceFinder();
    private final AsyncFaultyExchangeService exchangeService = new AsyncFaultyExchangeService();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        new PriceCatalogueByCF().findPriceInLocalCurrency(Currency.EUR, "Nexus 5");
    }

    private void findPriceInLocalCurrency(Currency localCurrency, String productName) {
        long time = System.currentTimeMillis();

        CompletableFuture<Product> product
                = CompletableFuture.supplyAsync(() -> catalogue.getProductByName(productName), executorService);

        CompletableFuture<Price> price =
                CompletableFuture.supplyAsync(() -> priceFinder.findBestPrice(product.join()), executorService);

        CompletableFuture<Double> exchangeRate =
                CompletableFuture.supplyAsync(() -> exchangeService.lookUpExchangeRateAsyncCall(USD, localCurrency).join(), executorService);

        double localPrice = exchange(exchangeRate.join(), price.join());

        System.out.printf("A %s will cost us %f %s\n", productName, localPrice, localCurrency);
        System.out.printf("It took us %d ms to calculate this\n", System.currentTimeMillis() - time);

        executorService.shutdown();

    }

    private double exchange(Double exchangeRate, Price price) {
        return Utils.round(price.getPrice() * exchangeRate);
    }
}
