package thread.priceFinder;

import async.enumFiles.*;
import thread.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * Created by Vivek Kumar Mishra on 31/08/2018.
 */
public class PriceFinderAll {

    private final PriceFinder priceFinder = new PriceFinder();
    private final FaultyExchangeService exchangeService = new FaultyExchangeService();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        new PriceFinderAll().finalDiscountedPrice(Currency.CHF, Catalogue.listProducts);
    }

    private void finalDiscountedPrice(Currency currency, List<Product> listProducts) {
        long time = System.currentTimeMillis();

        CompletableFuture<Double> exchangeFuture =
                CompletableFuture.supplyAsync(() -> exchangeService.lookupExchangeRateWithoutException(Currency.USD, currency), executorService);

        List<CompletableFuture<Price>> futureList = listProducts.stream().map(product -> CompletableFuture.supplyAsync(new Supplier<Price>() {
            @Override
            public Price get() {
                return priceFinder.findBestPrice(product);
            }
        }, executorService)).collect(toList());

        CompletableFuture<List<Price>> priceLists = sequence(futureList);

        priceLists.thenCombine(exchangeFuture, (list, exchangeRate) -> list.stream().mapToDouble(price ->
            exchange(price, exchangeRate)).sum()).thenAccept(totalPrice -> System.out.printf("Total price is %f %s\n", totalPrice, currency)).join();

        System.out.printf("Time Takes is  %d ms to calculate this\n", System.currentTimeMillis() - time);

        executorService.shutdown();
    }

    private double exchange(Price price, Double exchangeRate) {
        return Utils.round(price.getPrice() * exchangeRate);
    }

    private <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futureList) {
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));

        return completableFuture.thenApply(v ->
                futureList.stream().map(CompletableFuture::join).collect(toList()));
    }

}