package by.itacademy.items.impl;

import by.itacademy.Data;
import by.itacademy.items.GeneralBaseMenuItem;
import by.itacademy.items.MenuItem;

public class ListMenuItem extends GeneralBaseMenuItem implements MenuItem {
    public ListMenuItem(Data data, MenuItem menuItem) {
        super(data, menuItem);
    }

    @Override
    public void baseExecute() {
        data().list();
    }

    @Override
    public String name() {
        return "отоброжения базы пациентов";
    }
}