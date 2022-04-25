package by.knit.it.service;


import by.knit.it.entity.Order;
import by.knit.it.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public void save(
            String status,
            String customerName,
            String customerphone,
            String customeraddress,
            String customercomment
    ) {
        Order order = new Order();
        order.setStatus(status);
        order.setCustomername(customerName);
        order.setCustomerphone(customerphone);
        order.setCustomeraddress(customeraddress);
        order.setCustomercomment(customercomment);
        save(order);
    }

    private void save(Order order) {
        repository.save(order);//метод, который все это сохраняет

    }
}
