package by.knit.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userId", "role"})

    public class OrderController {

    @GetMapping("/order")
    public String showOrderPage() {
        return "order_page";
    }
}
