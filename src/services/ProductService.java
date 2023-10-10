package services;

import models.Product;

import java.util.List;

public interface ProductService {
    String createProduct (String productName, Long price);

    Product findById (Long id);


    Product updateProduct (Long id, String productName, Long price);

    String deleteProduct (Long id);

    List<Product> allProduct ();

}