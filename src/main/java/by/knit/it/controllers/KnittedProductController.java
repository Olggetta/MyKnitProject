package by.knit.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userId", "role"})
public class KnittedProductController {

    @GetMapping("/knitted_product")
    public String showKnittedProductPage() {
        return "knitted_product_page";
    }
}
