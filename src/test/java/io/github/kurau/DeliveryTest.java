package io.github.kurau;

import org.junit.Test;

import static io.github.kurau.Dimension.BIG;
import static io.github.kurau.Dimension.SMALL;
import static io.github.kurau.Distance.LESS_THAN_30KM;
import static io.github.kurau.Distance.MORE_THAN_30KM;
import static io.github.kurau.Fragility.FRAGILE;
import static io.github.kurau.Workload.VERY_HIGH;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeliveryTest {

    private static final double DEFAULT_DELIVERY_PRICE = 400;

    private Delivery delivery = Delivery.delivery();

    @Test
    public void shouldSeeMinDeliveryPriceForNothing() {
        assertThat(delivery.deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldSeeMaxDeliveryPriceForMaxDistance() {
        assertThat(delivery
                .setDistance(MORE_THAN_30KM)
                .setDimension(BIG)
                .setWorkload(VERY_HIGH)
                .deliveryPrice(), is(800.0));
    }

    @Test
    public void shouldSeeMaxDeliveryPriceForFragile() {
        assertThat(delivery
                .setDistance(LESS_THAN_30KM)
                .setDimension(BIG)
                .setWorkload(VERY_HIGH)
                .setFragility(FRAGILE)
                .deliveryPrice(), is(800.0));
    }

    @Test
    public void shouldSeeDeliveryPriceGreaterThanMin() {
        double expected = DEFAULT_DELIVERY_PRICE + 100;

        assertThat(delivery
                .setDistance(MORE_THAN_30KM)
                .setDimension(BIG).deliveryPrice(), is(expected));
    }

    @Test
    public void shouldUseWorkloadForPriceGreaterThanMin() {
        double expected = DEFAULT_DELIVERY_PRICE + 100;

        assertThat(delivery
                .setDistance(MORE_THAN_30KM)
                .setDimension(BIG).deliveryPrice(), is(expected));
    }

    @Test
    public void shouldSeeDeliveryPriceForSmallDimensionAndMaxDistance() {
        assertThat(delivery
                .setDistance(MORE_THAN_30KM)
                .setDimension(SMALL).deliveryPrice(), is(400.0));
    }
}
