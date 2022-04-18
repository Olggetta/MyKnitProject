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
            String knittedProductId,
            String authorUsername,
            String authorId,
            String product,
            String photo,
            String status,
            String description,
            String order

    ) {
        KnittedProduct knittedProduct = new KnittedProduct();
        knittedProduct.setKnittedProductId(knittedProductId);
        knittedProduct.setAuthorUsername(authorUsername);
        knittedProduct.setAuthorId(authorId);
        knittedProduct.setProduct(product);
        knittedProduct.setPhoto(photo);
        knittedProduct.setStatus(status);
        knittedProduct.setDescription(description);
        knittedProduct.setOrder(order);
        knittedProduct.setCreatedDate(LocalDateTime.now());
        save(knittedProduct);
    }

    private void save(KnittedProduct knittedProduct) {
        repository.save(knittedProduct);//метод, который все это сохраняет

    }
}