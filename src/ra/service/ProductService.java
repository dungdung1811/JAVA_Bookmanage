package ra.service;

import ra.model.Catalog;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product,String>{
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(String productId) {
        for (Product product: products) {
            if (product.getProductId().equals(productId)){
                return product;
            }
        }
        return null;

    }

    @Override
    public void delete(String productId) {
        Product productDelete = null;
        for (Product product: products) {
            if (product.getProductId().equals(productId)){
                productDelete = product;
                break;
            }
        }
        if(productDelete != null){
            products.remove(productDelete);
        }

    }
}
