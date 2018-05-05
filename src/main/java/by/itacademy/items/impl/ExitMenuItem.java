package by.itacademy.items.impl;

import by.itacademy.Data;
import by.itacademy.items.BaseMenuItem;
import by.itacademy.items.MenuItem;

public class ExitMenuItem extends BaseMenuItem implements MenuItem {
    protected ExitMenuItem(Data data) {
        super(data);
    }

    @Override
    public void execute() {
    }

    @Override
    public String name() {
        return "выхода из программы.";
    }
}