package com.codegym.Controller;

import com.codegym.Model.Product;
import com.codegym.Model.ProductList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class UserController {
    private static ArrayList<Product> productList = new ArrayList<>();
    private static int listLength=0;
    static {
        productList.add(new Product(0, "Nokia", 3.0, "Vietnam"));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId(listLength++);
        productList.add(product);
        redirect.addAttribute("success", "New product added successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productList.get(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Product product) {
        updateFields(product);
        return "redirect:/";
    }

    private static void updateFields(Product product) {
        Product listElement = (Product) productList.get(product.getId());
        listElement.setId(product.getId());
        listElement.setName(product.getName());
        listElement.setPrice(product.getPrice());
        listElement.setOrigin(product.getOrigin());
    }

    @GetMapping("/{id}/delete")
    public String edit(@PathVariable int id, RedirectAttributes redirect) {
        productList.remove(id);
        redirect.addAttribute("Success", "Delete successfully");
        return "redirect:/";
    }

}
