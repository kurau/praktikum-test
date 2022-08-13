package io.github.kurau;

import lombok.Getter;

public enum  Dimension {

    SMALL(100),
    BIG(200);

    @Getter
    private int price;

    Dimension(int price) {
        this.price = price;
    }

}
