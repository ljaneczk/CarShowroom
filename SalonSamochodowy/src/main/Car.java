package main;

import java.util.ArrayList;

public class Car
{
    private ArrayList <Component> equipment;
    private Engine engine;

    Car(ArrayList <Component> equipment, Engine engine) {
        this.equipment = equipment;
        this.engine = engine;
    }

    public double countPrice() {
        double price = 0;
        for (Component component : equipment) {
            price += component.getPrice();
        }
        return price;
    }

    public String generateDescription() {
        String description = "";
        for (Component component : equipment) {
            description += (component.toString() + "\n");
        }
        description += ("Engine = " + engine.toString());
        return description;
    }

    public Engine getEngine() {
        return engine;
    }

    public ArrayList<Component> getEquipment() {
        return equipment;
    }
}
