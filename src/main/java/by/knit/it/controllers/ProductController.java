package by.knit.it.controllers;


import by.knit.it.service.CreateProductService;
import by.knit.it.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userId", "role"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CreateProductService createProductService;

    @GetMapping("/create_product") //выводит страницу
    public String showPageWithListOfProduct(Model model) {
        model.addAttribute("createProductList", productService.getAllProducts());
        model.addAttribute("thisIsCreationproductStage", false);
        return "create_product_page";
    }

    @GetMapping("/create-product")
    public String showPageForCreatingProduct(Model model) {
        model.addAttribute("thisIsCreationProductStage", true);
        //thisIsCreationTopicStag - видоизменяет возращаемую страницу
        //как только мы создадим поле для обсуждения,появится возможность заполнить данные
        return "create_product_page";
    }
}
