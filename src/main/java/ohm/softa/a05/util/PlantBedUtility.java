package ohm.softa.a05.util;

import java.util.HashMap;
import java.util.Map;

import ohm.softa.a05.collections.*;
import ohm.softa.a05.PlantBed;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;

public abstract class PlantBedUtility {

    private PlantBedUtility() {
    };

    public static <T extends Plant> Map<PlantColor, SimpleList<T>> splitBedByColor(PlantBed<T> bed) {
        Map<PlantColor, SimpleList<T>> bedMap = new HashMap<>();
        for (PlantColor color : PlantColor.values()) {
            bedMap.put(color, bed.getPlantsByColor(color));
        }
        return bedMap;
    }

    public static <T extends Plant> void repot(PlantBed<T> from, PlantBed<? super T> to, PlantColor color){
        SimpleList<T> plantsByColor = from.getPlantsByColor(color);

        for(T plant : plantsByColor){
            from.removePlant(plant);
            to.add(plant);
        }

    }
}
