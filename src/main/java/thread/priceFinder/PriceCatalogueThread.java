package thread.priceFinder;

import thread.*;

/**
 * Created by Vivek Kumar Mishra on 21/07/2018.
 */
public class PriceCatalogueThread {

    private final PriceFinder priceFinder = new PriceFinder();
    private final Catalogue catalogue = new Catalogue();
    private final ExchangeService exchangeService = new ExchangeService();

    public static void main(String[] args) throws InterruptedException {

        new PriceCatalogueThread().findDiscountPrice(Currency.CHF, "Nexus 5");
    }

    private void findDiscountPrice(final Currency chf, final String productName) throws InterruptedException {
        long time = System.currentTimeMillis();

        PriceRunnable priceRunnable  = new PriceRunnable(productName);
        ExchangeRunnable exchangeRunnable = new ExchangeRunnable(chf);

        Thread priceThread = new Thread(priceRunnable);
        Thread exchangeThread = new Thread(exchangeRunnable);

        priceThread.start();
        exchangeThread.start();

        priceThread.join();
        exchangeThread.join();

        double exchange = exchange(priceRunnable.getPrice(), exchangeRunnable.getExchangeRate());
        System.out.printf("A %s will cost us %f %s\n", productName, exchange, chf);
        System.out.printf("It took us %d ms to calculate this\n", System.currentTimeMillis() - time);
    }

    private double exchange(Price price, double exchangeRate) {

        return Utils.round(price.getPrice() * exchangeRate);
    }


    private class PriceRunnable implements Runnable {
        private final String productName;
        private Price price;

        public PriceRunnable(String productName) {
            this.productName = productName;
        }

        @Override
        public void run() {
            Product product = catalogue.getProductByName(productName);
            Price price  = priceFinder.findBestPrice(product);
            this.price = price;
        }

        public Price getPrice() {
            return price;
        }
    }

    private class ExchangeRunnable implements Runnable {

        private Currency chf;
        private double exchangeRate;

        public ExchangeRunnable(Currency chf) {
            this.chf = chf;
        }

        @Override
        public void run() {
            double exchangeRate = exchangeService.lookupExchangeRate(Currency.USD, chf);
            this.exchangeRate = exchangeRate;
        }

        public double getExchangeRate() {
            return exchangeRate;
        }
    }
}
