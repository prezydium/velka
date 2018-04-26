package eu.sii.pl.velka.view;

import com.vaadin.data.Binder;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractDataForm<T> extends VerticalLayout {

    private T objectForBinder;

    protected Binder binder;

    public <T> void setModel(T t){
        binder.setBean(t);
    }

    public AbstractDataForm(){
        this.initialiseBinderWithSpecificClass();
    }

    public T getModel(){
        return (T) binder.getBean();
    }

    abstract public void initialiseBinderWithSpecificClass();

}

