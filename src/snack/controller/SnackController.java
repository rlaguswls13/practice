package snack.controller;

import snack.SnackConstants;
import snack.entity.Snack;

public class SnackController {
    private final Snack s = new Snack();

    public SnackController() {
    }

    public String saveData(String kind, String name, String flavor, int numOf, int price) {
        s.setKind(kind);
        s.setName(name);
        s.setFlavor(flavor);
        s.setNumOf(numOf);
        s.setPrice(price);
        return SnackConstants.MSG_SAVE_SUCCESS;
    }

    public String confirmData() {
        return s.information();
    }
}
