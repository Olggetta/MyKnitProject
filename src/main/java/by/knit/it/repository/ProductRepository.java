package by.knit.it.repository;

import by.knit.it.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepository extends JpaRepository<Product, String> {
}


