package ohm.softa.a05.model;

public abstract class Plant implements Comparable<Plant> {

    Plant(double height, String family, String name, PlantColor color) {
        this.height = height;
        this.family = family;
        this.name = name;
        this.color = color;
    }

    private double height;

    public double getHeight() {
        return height;
    }

    private String family;

    public String getFamily() {
        return family;
    }

    private String name;

    public String getName() {
        return name;
    }

    private PlantColor color;

    public PlantColor getColor() {
        return color;
    }

    @Override
    public int compareTo(Plant o) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Family: %s, Height; %d, Color: $s",
                this.getName(), this.getFamily(), this.getHeight(), this.getColor().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Plant))
            return false;
        Plant other = (Plant) o;

        return this.getHeight() == other.getHeight() &&
                this.getColor() == other.getColor() &&
                this.getName() == other.getName() &&
                this.getFamily() == other.getFamily();
    }
}