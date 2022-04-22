package by.knit.it.controllers;

import by.knit.it.service.OrderService;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userId", "role"})

    public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String showOrderPage() {
        return "order_page";
    }
}
