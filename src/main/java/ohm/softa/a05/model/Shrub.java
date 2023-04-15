package ohm.softa.a05.model;

public class Shrub extends Plant {

    public Shrub(double height, String family, String name) {
        super(height, family, name, PlantColor.GREEN);
    }

    @Override
    public String toString(){
        return String.format("Shrub, %s", super.toString());
    }
}
