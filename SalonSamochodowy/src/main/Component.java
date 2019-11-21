package main;

public class Component {
    private double price;
    private String name;
    private String description;

    public Component(int price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Component(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " " + this.description;
    }
}
