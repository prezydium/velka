package eu.sii.pl.velka.ui.views.components;

import eu.sii.pl.velka.model.Debtor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;

public class HeaderLayoutTest {

    @Test
    public void shouldCreateHeaderWithThreeComponents(){
        HeaderLayout headerLayout = new HeaderLayout(new Debtor("John", "Smith", "111-111-111", Collections.emptyList()));
        Assertions.assertThat(headerLayout.getComponentCount()).isEqualTo(3);
    }

}