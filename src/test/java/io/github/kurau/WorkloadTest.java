package io.github.kurau;

import org.junit.Test;

import static io.github.kurau.Dimension.BIG;
import static io.github.kurau.Distance.LESS_THAN_10KM;
import static io.github.kurau.Distance.MORE_THAN_30KM;
import static io.github.kurau.Fragility.FRAGILE;
import static io.github.kurau.Workload.DEFAULT;
import static io.github.kurau.Workload.HEAVY;
import static io.github.kurau.Workload.INCREASED;
import static io.github.kurau.Workload.VERY_HIGH;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WorkloadTest {

    private static final double DEFAULT_DELIVERY_PRICE = 400;

    private Delivery delivery = Delivery.delivery();

    @Test
    public void shouldSeeDefaultWorkload() {
        assertThat(delivery
                .setWorkload(DEFAULT).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldSeeIncreasedWorkload() {
        double expected = DEFAULT_DELIVERY_PRICE * 1.2;

        assertThat(delivery
                .setWorkload(INCREASED).deliveryPrice(), is(expected));
    }

    @Test
    public void shouldSeeHeavyWorkload() {
        double expected = DEFAULT_DELIVERY_PRICE * 1.4;

        assertThat(delivery
                .setWorkload(HEAVY).deliveryPrice(), is(expected));
    }

    @Test
    public void shouldSeeVeryHighWorkload() {
        double expected = DEFAULT_DELIVERY_PRICE * 1.6;

        assertThat(delivery
                .setWorkload(VERY_HIGH).deliveryPrice(), is(expected));
    }

    @Test
    public void shouldUseWorkloadAfterAddingDistanceAndDimension() {
        assertThat(delivery
                .setDistance(MORE_THAN_30KM)
                .setDimension(BIG)
                .setWorkload(HEAVY).deliveryPrice(), is(700.0));
    }

    @Test
    public void shouldUseWorkloadAfterAddingDistanceAndFragileAndDimension() {
        assertThat(delivery
                .setDistance(LESS_THAN_10KM)
                .setDimension(BIG)
                .setFragility(FRAGILE)
                .setWorkload(HEAVY)
                .deliveryPrice(), is(560.0));
    }
}
