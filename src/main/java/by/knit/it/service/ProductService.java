package by.knit.it.service;

import by.knit.it.entity.Product;


import by.knit.it.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void save(
            String productname,
            String pathToImage,
            String description

    ) {
        Product product = new Product();
        product.setDescription(productname);
        product.setPathToImage(pathToImage);
        product.setDescription(description);
        product.setCreatedDate(LocalDateTime.now());
        save(product);
    }

    private void save(Product product) {
       productRepository.save(product);//метод, который все это сохраняет

    }

    //создаем метод для вывода всех изделий
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}