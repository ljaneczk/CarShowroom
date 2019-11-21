package tests;

import org.junit.Assert;
import org.junit.Test;
import java.util.Random;
import static java.lang.Math.abs;
import static org.junit.Assert.*;
import main.*;


public class EnginePriceCalculatorTest {

    private EnginePriceCalculator calculator = new EnginePriceCalculator();

    private Capacity[] capacities = Capacity.values();
    private EngineType[] engineTypes = EngineType.values();

    @Test
    public void testInserting() {
        int size = 10000, value, q = 1000000; double value1; Capacity capacity; EngineType type;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            value = random.nextInt();
            if (value == Integer.MIN_VALUE)
                continue;
            value = (abs(value)) % q;         //Negative price cannot be inserted
            capacity = capacities[value % capacities.length];
            type = engineTypes[value % engineTypes.length];
            value1 = 1.0 * value;
            System.err.println("Testing: " + value1 + " " + capacity + " " + type);
            assertTrue(calculator.addPrice(capacity, type, value1));
            Assert.assertEquals(value1, calculator.getPrice(capacity, type), 0.001);    //Value is Properly added
            Assert.assertEquals(value1, calculator.getPrice(capacity, type), 0.001);    //Value is not deleted after get
            assertTrue(calculator.removePrice(capacity, type));                 //Value is in map
            if (value > 0) {
                assertFalse(calculator.addPrice(capacity, type, (-1) * value1)); //Negative price cannot be inserted
            }
            calculator.addPrice(capacity, type, value);
        }
    }
}