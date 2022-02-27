package fr.etienne.myuka.model;

import fr.etienne.myuka.service.ProductService;
import org.json.simple.parser.ParseException;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private String email;
    private List<Product> productList;
    private static Map<String,Basket> basketList = null;

    public Basket(String email) {
        this.email = email;
        productList = new ArrayList<>();
        basketList.put(email,this);
    }

    public static void initBasketList(){
        try {
            if(basketList == null) {
                basketList = new HashMap<>();
                Basket elt1 = new Basket("etienne.gouinaud@gmail.com");
                elt1.addProduct(new ProductService().getProduct("5000159462365"));
                elt1.addProduct(new ProductService().getProduct("8410076900302"));
                Basket elt2 = new Basket("simon.mocassin@live.com");
                elt2.addProduct(new ProductService().getProduct("8410076900302"));
                elt2.addProduct(new ProductService().getProduct("8410076900302"));
                elt2.addProduct(new ProductService().getProduct("8410076900302"));
                elt2.addProduct(new ProductService().getProduct("8410076900302"));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public static Basket getBasket(String email){
        initBasketList();
        return basketList.get(email);
    }

    @Override
    public String toString() {
        String response = "Basket{" +
                "email='" + email + '\'' +
                ", productList=";
        for (Product product:
                productList
             ) {
            response += product.toString() + ",";

        }


        response += '}';
        return response;
    }
}
