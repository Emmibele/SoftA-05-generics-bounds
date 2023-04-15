package ohm.softa.a05.model;

public class Flower extends Plant {

    public Flower(double height, String family, String name, PlantColor color) {
        super(height, family, name, color);

        if (color.equals(PlantColor.GREEN)) {
            throw new IllegalArgumentException("Flower cannot be green");
        }
    }

    @Override
    public int compareTo(Plant o) {
        if (!(o instanceof Flower))
            return super.compareTo(o);

        return (int) (this.getHeight() - o.getHeight());
    }

    @Override
    public String toString(){
        return String.format("Flower, %s", super.toString());
    }
}
