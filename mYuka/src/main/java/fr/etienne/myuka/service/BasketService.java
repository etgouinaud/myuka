package fr.etienne.myuka.service;

import fr.etienne.myuka.model.Basket;
import fr.etienne.myuka.model.Product;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    public Basket getBasket(String email){
        return Basket.getBasket(email);
    }
}
