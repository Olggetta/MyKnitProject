package by.knit.it.repository;

import by.knit.it.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order, String> {
}
