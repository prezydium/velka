package eu.sii.pl.velka.view;

import com.vaadin.data.Binder;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractDataForm<T> extends VerticalLayout {

    private T objectForBinder;

    protected final Binder binder;

    public <T> void setModel(T t){
        binder.setBean(t);
    }

    public AbstractDataForm(){
        binder = new Binder(getModelClass());
    }

    protected abstract Class<T> getModelClass();

    public T getModel(){
        return (T) binder.getBean();
    }

}