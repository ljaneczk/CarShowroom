import java.util.HashMap;
import java.util.Map;

public abstract class EnginePriceCalculator
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
            return super.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (! (o instanceof Key))
                return false;
            Key that = (Key) o;
            return (this.capacity == that.capacity && this.type == that.type);
        }
    }


    private static Map <Key, Integer> priceCalculator = new HashMap<>();


    public int getPrice(Capacity capacity, EngineType type) {
        Key key = new Key(capacity, type);
        if (priceCalculator.containsKey(key))
            return priceCalculator.get(key);
        else {
            System.err.println("There is no price with " + key);
            return 0;
        }
    }

    public void addPrice(Capacity capacity, EngineType type, int price) {
        Key key = new Key(capacity, type);
        if (! priceCalculator.containsKey(key))
            priceCalculator.put(key, price);
        else {
            System.err.println("There was price " + priceCalculator.get(key) + "with " + key);
            priceCalculator.put(key, price);
        }
    }

    public void removePrice(Capacity capacity, EngineType type) {
        Key key = new Key(capacity, type);
        if (priceCalculator.containsKey(key))
            priceCalculator.remove(key);
        else {
            System.err.println("There is no price with " + key);
        }
    }

    /* UZNALIŚMY TO ZA NIEPOTRZEBNE
    public int getPrice1(Capacity capacity, EngineType type) {
        switch (type) {
            case DIESEL:
                switch (capacity) {
                    case SMALL:
                        return (1<<10);
                    case MEDIUM:
                        return (1<<11);
                    case BIG:
                        return (1<<12);
                    case VERY_BIG:
                        return (1<<13);
                }
            case PETROL:
                switch (capacity) {
                    case SMALL:
                        return (1<<11);
                    case MEDIUM:
                        return (1<<12);
                    case BIG:
                        return (1<<13);
                    case VERY_BIG:
                        return (1<<14);
                }
        }
        return 0;
    }*/

}
