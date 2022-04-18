package by.knit.it.repository;

import by.knit.it.entity.KnittedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface KnittedProductRepository extends JpaRepository<KnittedProduct, String> {
}
