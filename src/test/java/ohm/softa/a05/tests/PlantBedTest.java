package ohm.softa.a05.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ohm.softa.a05.PlantBed;
import ohm.softa.a05.collections.SimpleListImpl;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;

public class PlantBedTest {

    private final Logger logger = LogManager.getLogger();

    private PlantBed<Flower> flowerBed;
    private PlantBed<Plant> plantBed;

    @BeforeEach
    void setup() {
        plantBed = new PlantBed<>();
        flowerBed = new PlantBed<>();

        plantBed.add(new Flower(3, null, null, PlantColor.RED));
        plantBed.add(new Flower(1, null, null, PlantColor.RED));
        plantBed.add(new Flower(2, null, null, PlantColor.BLUE));
        plantBed.add(new Flower(3, null, null, PlantColor.YELLOW));
        plantBed.add(new Shrub(1, null, null));
        plantBed.add(new Shrub(2, null, null));

        flowerBed.add(new Flower(2, null, null, PlantColor.RED));
        flowerBed.add(new Flower(1, null, null, PlantColor.RED));
        flowerBed.add(new Flower(3, null, null, PlantColor.BLUE));
        flowerBed.add(new Flower(5, null, null, PlantColor.YELLOW));
    }

    @Test
    void testGetSize() {
        logger.info("Testing bed sizes");

        assertEquals(flowerBed.size(), 4);
        assertEquals(plantBed.size(), 6);
    }

    @Test
    void testGetByColor() {
        SimpleListImpl<Plant> redPlants = (SimpleListImpl<Plant>) plantBed.getPlantsByColor(PlantColor.RED);

        assertEquals(redPlants.size(), 2);

        for (Plant plant : redPlants) {
            assertTrue(plant.getColor().equals(PlantColor.RED));
        }

    }
}
