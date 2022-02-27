package fr.etienne.myuka.model;

public class Product {
    private int id;
    private String barCode;
    private String name;
    private double energy;
    private double fat;
    private double sugar;
    private double salt;
    private double fiber;
    private double protein;
    private static int count = 0;

    public Product( String barCode, String name, double energy, double fat, double sugar, double salt, double fiber, double protein){
        this.id = count;
        count++;
        this.barCode = barCode;
        this.name = name;
        this.energy = energy;
        this.fat = fat;
        this.sugar = sugar;
        this.salt = salt;
        this.fiber = fiber;
        this.protein = protein;
    }
    public Product(){
        this.id = count;
        count++;
    }

    int composanteN(){
        int score = 0;
        if(energy <= 3350) {
            score +=  (energy / 335);
        }else{
            score += 10;
        }
        if(fat <= 10) {
            score +=  (fat);
        }else{
            score += 10;
        }
        if(sugar <= 45) {
            score +=  (sugar / 4.5);
        }else{
            score += 10;
        }
        if(salt <= 900) {
            score +=  (salt / 90);
        }else{
            score += 10;
        }
        return score;
    }

    int composanteP(){
        int score = 0;
        if(fiber <= 4.7) {
            score +=  (fiber / 0.9);
        }else{
            score += 5;
        }
        if(protein <= 8) {
            score +=  (protein / 1.6);
        }else {
            score += 5;
        }
        return score;
    }

    int scoreNutrionnel(){
        return composanteN() - composanteP();
    }

    String classeAliment(){
        int score = scoreNutrionnel();
        if(score < 0){
            return "Trop Bon";
        }
        if(score < 3){
            return "Bon";
        }
        if(score < 11){
            return "Mangeable";
        }
        if(score < 19){
            return "Mouai";
        }
        return "Degueu";
    }

    String couleurAliment(){
        int score = scoreNutrionnel();
        if(score < 0){
            return "green";
        }
        if(score < 3){
            return "light green";
        }
        if(score < 11){
            return "yellow";
        }
        if(score < 19){
            return "orange";
        }
        return "red";
    }


    @Override
    public String toString() {
        return "{" +
                "\"barCode\" : \"" + barCode + '"' +
                ", \"name\" : \"" + name + '"' +
                ", \"nutritionScore\" : \"" + scoreNutrionnel() + '"' +
                ", \"classe\" : \"" + classeAliment() + '"' +
                ", \"color\" : \"" + couleurAliment() + '"' +
                '}';
    }


}
