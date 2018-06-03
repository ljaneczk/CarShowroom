package tests;

import org.junit.Assert;
import org.junit.Test;
import java.util.Random;
import static java.lang.Math.abs;
import static org.junit.Assert.*;
import main.*;


public class EnginePriceCalculatorTest {

    EnginePriceCalculator calculator = new EnginePriceCalculator();

    Capacity[] capacities = Capacity.values();
    EngineType[] engineTypes = EngineType.values();

    @Test
    public void testInserting() {
        int size = 10000, value, q = 1000000; Capacity capacity; EngineType type;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            value = random.nextInt();
            if (value == Integer.MIN_VALUE)
                continue;
            value = (abs(value)) % q;         //Negative price cannot be inserted
            capacity = capacities[value % capacities.length];
            type = engineTypes[value % engineTypes.length];
            System.out.println(value + " " + capacity + " " + type);
            assertTrue(calculator.addPrice(capacity, type, value));
            Assert.assertEquals(value, calculator.getPrice(capacity, type));    //Value is Properly added
            Assert.assertEquals(value, calculator.getPrice(capacity, type));    //Value is not deleted after get
            assertTrue(calculator.removePrice(capacity, type));                 //Value is in map
            if (value > 0)
                assertFalse(calculator.addPrice(capacity, type, (-1) * value)); //Negative price cannot be inserted
            calculator.addPrice(capacity, type, value);
        }
    }
}