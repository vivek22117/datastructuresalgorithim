package thread;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Vivek Kumar Mishra on 21/07/2018.
 */
public class Catalogue {

    private static final Product harryPotter = new Product(Product.Category.BOOK,"Harry Potter");
    private static final Product crackingInterview = new Product(Product.Category.BOOK, "Cracking Interview Guide");
    private static final Product iPhone7 = new Product(Product.Category.ELECTRONICS, "Iphone 7");
    private static final Product nexus5 = new Product(Product.Category.ELECTRONICS, "Nexus 5");
    private static final Product toothBrush = new Product(Product.Category.HEALTH, "Tooth Brush");

    public static final List<Product> listProducts =
            Arrays.asList(harryPotter, crackingInterview, iPhone7, nexus5, toothBrush);

    public final Map<String, Product> productByMap =
            listProducts.stream().collect(Collectors.toMap(Product::getName, product -> product));

    public Product getProductByName(String name){
        return productByMap.get(name);
    }
}
