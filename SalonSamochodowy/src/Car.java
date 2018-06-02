import java.util.ArrayList;

public class Car
{
    private ArrayList <Component> equipment;

    Car(ArrayList <Component> equipment) {
        this.equipment = equipment;
    }

    public int countPrice() {
        int price = 0;
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
        return description;
    }
}
