package by.knit.it.service;

import by.knit.it.entity.CreateProduct;
import by.knit.it.repository.CreateProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateProductService {

    @Autowired
    private CreateProductRepository createProductRepository;

    public void save(
            String productname,
            String pathToImage,
            String description

    ) {
        CreateProduct createProduct = new CreateProduct();
        createProduct.setDescription(productname);
        createProduct.setPathToImage(pathToImage);
        createProduct.setDescription(description);
        createProduct.setCreatedDate(LocalDateTime.now());
        save(createProduct);
    }

    private void save(CreateProduct createProduct) {
        createProductRepository.save(createProduct);//метод, который все это сохраняет

    }
}
