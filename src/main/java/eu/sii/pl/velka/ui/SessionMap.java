package eu.sii.pl.velka.ui;

import com.vaadin.ui.UI;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SessionMap {

    private Map<String, UI> uiStorage = new HashMap<>();

    public void addUIToMap(UI ui) {
        uiStorage.put("4", ui);
    }

    public UI getUiFromStorage(String s) {
        return uiStorage.get(s);
    }

}