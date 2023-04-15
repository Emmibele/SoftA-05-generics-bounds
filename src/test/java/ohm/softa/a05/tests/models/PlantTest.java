package ohm.softa.a05.tests.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;

public class PlantTest {

    private final Logger logger = LogManager.getLogger();
    private Flower smallerFlower, largerFlower;
    private Shrub someShrub;



    @BeforeEach
    void setup() {
        smallerFlower = new Flower(5.3, "CaringPlantFamily", "Blume", PlantColor.RED);
        largerFlower = new Flower(12, "CaringPlantFamily", "Blume", PlantColor.RED);
        someShrub = new Shrub(12, null, null);
    }

    @Test
    void createShrub() {
        logger.info("Testing creation of Shrub");

        Plant s = new Shrub(5.3, "CaringPlantFamily", "Busch");

        assertNotNull(s);
        assertEquals(s.getColor(), PlantColor.GREEN);
        assertTrue(s instanceof Shrub);
    }

    @Test
    void failCreateGreenFlower() {
        logger.info("Testing creation of Green Flower -> Expecting Exception");

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Flower(5.3, "CaringPlantFamily", "Blume", PlantColor.GREEN),
                "Expected Flower instanciation to fail, but didn't");

        assertTrue(thrown.getMessage().contentEquals("Flower cannot be green"));
    }

    @Test
    void compare(){
        logger.info("Testing comparing of Plants");

        assertTrue(smallerFlower.compareTo(largerFlower) < 0);
        assertTrue(smallerFlower.compareTo(smallerFlower) == 0);
        assertTrue(largerFlower.compareTo(smallerFlower) > 0);

        assertTrue(someShrub.compareTo(largerFlower) == 0);
        assertTrue(largerFlower.compareTo(someShrub) == 0);

    }
}
