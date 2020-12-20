public class Product{
    private String name;
    private double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void reducePrice(double rate){
        price *= (1 - rate);
    }

    public String toString(){
        return "Prodotto " + name + ", prezzo: " + price; 
    }
}
