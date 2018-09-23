package thread;

/**
 * Created by Vivek Kumar Mishra on 04/07/2018.
 */
public class Product {

    public enum Category{
        BOOK, ELECTRONICS, HEALTH, FOOD
    }

    private Category category;
    private String name;

    public Product(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (category != product.category) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}
