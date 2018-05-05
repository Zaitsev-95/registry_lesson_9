package by.itacademy;

import by.itacademy.items.MenuItem;
import by.itacademy.items.impl.GeneralMenuItem;

public class Menu {
    private MenuItem startMenu = new GeneralMenuItem();

    public void start() {
        startMenu.execute();
    }
}