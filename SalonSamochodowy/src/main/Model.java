package main;

public class Model
{
    private double price;
    private Type type;
    private String description;

    Model(double price, Type type, String description) {
        this.price = price;
        this.type = type;
        this.description = description;
    }

    Model(int price, Type type, String description) {
        this.price = (double) price;
        this.type = type;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.type + " " + this.description;
    }
}