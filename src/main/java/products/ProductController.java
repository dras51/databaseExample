package products;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ProductRepository productRepository  = new ProductRepository();

    public String createProduct(Product product) {
        try {
            productRepository.create(product);
            return "Product created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating product!";
        }

    }


    public void updateProduct(Product product) {

    }
    public ArrayList<Product> getAllProducts() {

        try {
        return productRepository.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product findProduct(String name) {
        return new Product();
    }
}
