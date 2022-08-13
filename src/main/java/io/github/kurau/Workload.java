package io.github.kurau;

import lombok.Getter;

public enum Workload {

    DEFAULT(1),
    INCREASED(1.2),
    HEAVY(1.4),
    VERY_HIGH(1.6);

    @Getter
    private double factor;

    Workload(double factor) {
        this.factor = factor;
    }

}
