package io.github.kurau;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static io.github.kurau.Distance.MORE_THAN_30KM;

public class NotDeliveryTest {

    private Delivery delivery = Delivery.delivery();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldNotDeliveryFragileMoreThan30Km() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("Не вывозим");

        delivery.setFragility(Fragility.FRAGILE)
                .setDistance(MORE_THAN_30KM)
                .deliveryPrice();
    }

}
