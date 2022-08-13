package io.github.kurau;

import lombok.Getter;

public enum Fragility {

    NOT_FRAGILE(0),
    FRAGILE(100);

    @Getter
    private int price;

    Fragility(int price) {
        this.price = price;
    }

}
