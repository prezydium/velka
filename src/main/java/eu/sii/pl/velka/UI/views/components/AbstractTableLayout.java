package eu.sii.pl.velka.UI.views.components;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractTableLayout<T> extends VerticalLayout {

    public abstract Grid setGridColumns(T t);

    public void createFooter(Grid grid, T t) {
    }
}
