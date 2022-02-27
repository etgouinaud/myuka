package fr.etienne.myuka.controller;

import fr.etienne.myuka.service.BasketService;
import fr.etienne.myuka.service.ProductService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketController {

    @Autowired
    private BasketService basketService;


    @GetMapping("/basket/{email}")
    public ResponseEntity getData(@PathVariable String email){
            return ResponseEntity.ok(basketService.getBasket(email).toString());

    }
}

