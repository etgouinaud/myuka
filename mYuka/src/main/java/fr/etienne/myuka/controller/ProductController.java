package fr.etienne.myuka.controller;

import fr.etienne.myuka.service.ProductService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/product/{barCode}")
    public ResponseEntity getData(@PathVariable String barCode){
        try {
            return ResponseEntity.ok(productService.getProduct(barCode).toString());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

