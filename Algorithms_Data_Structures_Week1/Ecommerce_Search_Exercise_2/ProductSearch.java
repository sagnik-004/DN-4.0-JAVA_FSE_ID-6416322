import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "T-shirt", "Apparel"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "Shoes", "Footwear"),
            new Product(105, "Watch", "Accessories")
        };
        System.out.println("Linear Search:");
        Product linearResult = linearSearch(products, "Shoes");
        System.out.println(linearResult != null ? linearResult : "Not found");
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("\nBinary Search:");
        Product binaryResult = binarySearch(products, "Mobile");
        System.out.println(binaryResult != null ? binaryResult : "Not found");
    }
}
