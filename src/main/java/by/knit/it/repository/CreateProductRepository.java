package by.knit.it.repository;


import by.knit.it.entity.CreateProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CreateProductRepository extends JpaRepository<CreateProduct, String> {
}
