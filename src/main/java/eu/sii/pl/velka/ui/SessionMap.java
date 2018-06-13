package eu.sii.pl.velka.ui;

import com.vaadin.ui.UI;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.WeakHashMap;

@Component
public class SessionMap {

    private Map<String, UI> uiStorage = new WeakHashMap<>();

    public void addUIToMap(String s, UI ui) {
        uiStorage.put(s, ui);
    }

    public UI getUiFromStorage(String s) {
        return uiStorage.get(s);
    }

    public void removeUIFromStorage(String s){
        uiStorage.remove(s);
    }
}