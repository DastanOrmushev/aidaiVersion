package services.impl;
import models.Product;
import services.DbHelper;
import services.ProductService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public String createProduct(String productName, Long price) {
        PreparedStatement preparedStatement =dbHelper.getStatement("insert into tb_product (name,price) values (?,?)");
        try {
            preparedStatement.setString(1,productName);
            preparedStatement.setLong(2,price);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return "Success";
        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при сохранении продукта");
        }
    }


    @Override
    public Product findById(Long id) {
        Product product = new Product();
        PreparedStatement ps = dbHelper.getStatement("select * from tb_product where id=?");
        try {
            ps.setLong(1,id);
            ResultSet resultSet =ps.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
            }
            return product;
        }catch (SQLException e) {
            throw new RuntimeException("Такого продукта нет");
        }
    }

    @Override
    public Product updateProduct(Long id, String productName, Long price) {
        PreparedStatement preparedStatement =dbHelper.getStatement("update tb_product set name=?,price=? where id=?");
        try {
            preparedStatement.setString(1,productName);
            preparedStatement.setLong(2,price);
            preparedStatement.setLong(3,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при изменении продукта");
        }
        return findById(id);
    }

    @Override
    public String deleteProduct(Long id) {
        PreparedStatement ps = dbHelper.getStatement("delete from tb_product where id=?");
        try {
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Такого продукта нет");
        }
        return "Deleted";
    }
    @Override
    public List<Product> allProduct() {
        List <Product> product = new ArrayList<>();
        PreparedStatement ps = dbHelper.getStatement("select * from tb_product");
        try {
            ResultSet resultSet =ps.executeQuery();
            while (resultSet.next()) {
                Product result = new Product();
                result.setId(resultSet.getLong("id"));
                result.setName(resultSet.getString("name"));
                result.setPrice(resultSet.getLong("price"));
                product.add(result);
            }
            return product;
        }catch (SQLException e) {
            throw new RuntimeException("Такого продукта нет");
        }
    }
}