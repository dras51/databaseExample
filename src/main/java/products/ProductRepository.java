package products;

import database.DBHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductRepository {
    DBHandler dbHandler = new DBHandler();

    public void create(Product product) throws SQLException {
        String query = "INSERT INTO products(name, price, quantity) VALUES(?,?,?)";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, product.name);
        preparedStatement.setFloat(2, product.price);
        preparedStatement.setInt(3, product.quantity);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public ArrayList<Product> getAll() throws SQLException {
        String query = "SELECT * FROM products";

        Statement statement = dbHandler.getConnection().createStatement();
        ResultSet results  = statement.executeQuery(query);

        ArrayList<Product> products = new ArrayList<>();

        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("name");
            Float price = results.getFloat("price");
            int quantity = results.getInt("quantity");

            Product product = new Product(name, price, quantity);
            products.add(product);
        }

        return products;
    }
}
