package fr.etienne.myuka.service;

import fr.etienne.myuka.model.Product;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    Product product = null;

    public Product getProduct(String barCode) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String urlApi
                = "https://fr.openfoodfacts.org/api/v0/produit/"+barCode+".json?fields=id,generic_name_fr,energy_100g,saturated-fat_100g,sugars_100g,salt_100g,fiber_100g,proteins_100g";
        String  response
                = restTemplate.getForObject(urlApi, String.class);

        JSONParser parser = new JSONParser();
        JSONObject object = new JSONObject(parser.parse(response).toString()).getJSONObject("product");

    // This allow to avoid crashing if a line isn't write in the API.
    try {
        product = new Product(
                barCode,
                object.getString("generic_name_fr").toString(),
                object.getDouble("energy_100g"),
                object.getDouble("saturated-fat_100g"),
                object.getDouble("sugars_100g"),
                object.getDouble("salt_100g"),
                object.getDouble("fiber_100g"),
                object.getDouble("proteins_100g")
        );
    }catch (JSONException e){
        product = new Product();
    }
    return product;
    }

}
