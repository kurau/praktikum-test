package io.github.kurau;

import lombok.Getter;

public enum Distance {

    LESS_THAN_2KM(50),
    LESS_THAN_10KM(100),
    LESS_THAN_30KM(200),
    MORE_THAN_30KM(300);

    @Getter
    private int price;

    Distance(int price) {
        this.price = price;
    }

}
