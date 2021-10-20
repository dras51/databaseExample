import database.DBHandler;
import products.Product;
import products.ProductController;

public class Main {
    public static void main(String[] args) {

        ProductController productController =  new ProductController();

        System.out.println(productController.getAllProducts());

    }
}
