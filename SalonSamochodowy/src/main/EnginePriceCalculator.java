package main;
import java.util.HashMap;
import java.util.Map;

public class EnginePriceCalculator
{
    private class Key {
        Capacity capacity;
        EngineType type;

        Key(Capacity capacity, EngineType type) {
            this.capacity = capacity;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Capacity = " + capacity + ", EngineType = " + type;
        }

        @Override
        public int hashCode() {
            return (capacity.toString()).length() * 100 + type.toString().length();
        }

        @Override
        public boolean equals(Object o) {
            if (! (o instanceof Key))
                return false;
            Key that = (Key) o;
            return (this.capacity == that.capacity && this.type == that.type);
        }
    }


    private Map <Key, Integer> priceCalculator = new HashMap<>();


    public int getPrice(Capacity capacity, EngineType type) {
        Key key = new Key(capacity, type);
        if (priceCalculator.containsKey(key))
            return priceCalculator.get(key);
        else {
            System.out.println("There is no price with " + key);
            return 0;
        }
    }

    public boolean addPrice(Capacity capacity, EngineType type, int price) {
        Key key = new Key(capacity, type);
        if (price < 0) {
            System.out.println("Price should not be less than 0.");
            return false;
        }
        if (priceCalculator.containsKey(key))
            System.out.println("There was price " + priceCalculator.get(key) + " with " + key);
        priceCalculator.put(key, price);
        return true;
    }

    public boolean removePrice(Capacity capacity, EngineType type) {
        Key key = new Key(capacity, type);
        if (priceCalculator.containsKey(key)) {
            priceCalculator.remove(key);
            return true;
        }
        else {
            System.err.println("There is no price with " + key);
            return false;
        }
    }

}
