package io.github.kurau;

import org.junit.Test;

import static io.github.kurau.Dimension.BIG;
import static io.github.kurau.Dimension.SMALL;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DimensionTest {

    private static final double DEFAULT_DELIVERY_PRICE = 400;

    private Delivery delivery = Delivery.delivery();

    @Test
    public void shouldSeeMinDeliveryPriceForOnlySmallCargo() {
        assertThat(delivery
                .setDimension(SMALL).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

    @Test
    public void shouldSeeMinDeliveryPriceForOnlyBigCargo() {
        assertThat(delivery
                .setDimension(BIG).deliveryPrice(), is(DEFAULT_DELIVERY_PRICE));
    }

}
