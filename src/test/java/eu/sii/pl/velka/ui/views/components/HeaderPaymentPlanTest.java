package eu.sii.pl.velka.ui.views.components;

import eu.sii.pl.velka.model.PaymentPlan;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;

public class HeaderPaymentPlanTest {

    @Test
    public void shouldCreateHeaderWithTwoElements(){
        HeaderPaymentPlan headerPaymentPlan = new HeaderPaymentPlan(new PaymentPlan("", "", Collections.EMPTY_LIST));
        Assertions.assertThat(headerPaymentPlan.getComponentCount()).isEqualTo(2);
    }

}