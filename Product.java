public class Product {
    private String name;
    private double price;
    private int id;
    private int quantity;

    public Product(String name, double price, int id, int quantity)
        {
            this.name = name;
            this.price = price;
            this.id = id;
            this.quantity = quantity;
        }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }

    public int getQuantity(){
        return quantity;
    }

    public void updateQuantity(int purchase){
        if(quantity >= purchase)
        {
            quantity -= purchase;
        }
        else
        {
            System.out.println("Product Out of Stock!");
        }
    }
}
