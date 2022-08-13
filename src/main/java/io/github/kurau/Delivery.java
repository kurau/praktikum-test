package io.github.kurau;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Optional;

import static io.github.kurau.Dimension.SMALL;
import static io.github.kurau.Distance.LESS_THAN_2KM;
import static io.github.kurau.Distance.MORE_THAN_30KM;
import static io.github.kurau.Fragility.FRAGILE;
import static io.github.kurau.Fragility.NOT_FRAGILE;
import static io.github.kurau.Workload.DEFAULT;

@Accessors(chain = true)
public class Delivery {

    public static final double MIN_DELIVERY_PRICE = 400;

    @Setter
    private Distance distance = LESS_THAN_2KM;
    @Setter
    private Dimension dimension = SMALL;
    @Setter
    private Fragility fragility = NOT_FRAGILE;
    @Setter
    private Workload workload = DEFAULT;


    public static Delivery delivery() {
        return new Delivery();
    }


    public double deliveryPrice() {
        int sum = 0;
        double result;

        if (distance.equals(MORE_THAN_30KM) && fragility.equals(FRAGILE)) {
            throw new IllegalStateException(" Не вывозим ");
        }

        sum = sum + distance.getPrice();

        sum = sum + dimension.getPrice();

        sum = sum + fragility.getPrice();

        result = Math.max(MIN_DELIVERY_PRICE, sum);

        return result * workload.getFactor();
    }

}
