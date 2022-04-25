package by.knit.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userId", "role"})
public class CatalogController {

    @GetMapping("/catalog")
    public String showCatalogPage() {
        return "catalog_page";
    }
    // @PostMapping("/catalog")
    // public String;


}