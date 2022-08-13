package io.github.kurau;

import org.junit.Test;

import static io.github.kurau.Dimension.BIG;
import static io.github.kurau.Distance.LESS_THAN_2KM;
import static io.github.kurau.Distance.LESS_THAN_30KM;
import static io.github.kurau.Fragility.FRAGILE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FragilityTest {

    private static final double DEFAULT_DELIVERY_PRICE = 400;

    private Delivery delivery = Delivery.delivery();

    @Test
    public void shouldSeeMinDeliveryPriceForNotFragile() {
        assertThat(delivery
                .setFragility(Fragility.NOT_FRAGILE).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldSeeMinDeliveryPriceForFragile() {
        assertThat(delivery
                .setFragility(FRAGILE).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldDeliveryFragileLessThan30Km() {
        assertThat(delivery
                .setDistance(LESS_THAN_30KM)
                .setFragility(FRAGILE).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldDeliveryFragileForMinDistance() {
        assertThat(delivery
                .setDistance(LESS_THAN_2KM)
                .setFragility(FRAGILE).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldDeliveryFragileForBigDimension() {
        assertThat(delivery
                .setDimension(BIG)
                .setFragility(FRAGILE).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }
}
