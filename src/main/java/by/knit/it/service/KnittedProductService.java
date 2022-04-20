package by.knit.it.service;

import by.knit.it.entity.KnittedProduct;

import by.knit.it.repository.KnittedProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KnittedProductService {
    @Autowired
    private KnittedProductRepository repository;

    public void save(
            String pathToImage,
            String description
    ) {
        KnittedProduct knittedProduct = new KnittedProduct();
        knittedProduct.setPathToImage(pathToImage);
        knittedProduct.setDescription(description);
        knittedProduct.setCreatedDate(LocalDateTime.now());
        save(knittedProduct);
    }

    private void save(KnittedProduct knittedProduct) {
        repository.save(knittedProduct);//метод, который все это сохраняет

    }
}