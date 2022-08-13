package io.github.kurau;

import org.junit.Test;

import static io.github.kurau.Distance.LESS_THAN_10KM;
import static io.github.kurau.Distance.LESS_THAN_2KM;
import static io.github.kurau.Distance.LESS_THAN_30KM;
import static io.github.kurau.Distance.MORE_THAN_30KM;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DistanceTest {

    private static final double DEFAULT_DELIVERY_PRICE = 400;

    private Delivery delivery = Delivery.delivery();

    @Test
    public void shouldSeeMinDeliveryPriceForOnlyMinDistance() {
        assertThat(delivery
                .setDistance(LESS_THAN_2KM).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldSeeMinDeliveryPriceForMidDistance() {
        assertThat(delivery
                .setDistance(LESS_THAN_10KM).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldSeeMinDeliveryPriceForLessThanMaxDistance() {
        assertThat(delivery
                .setDistance(LESS_THAN_30KM).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldSeeMinDeliveryPriceForMaxDistance() {
        assertThat(delivery
                .setDistance(MORE_THAN_30KM).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

}
