package fr.ensai.library;

import java.time.Year;

public abstract class Item {
    protected String title;
    protected int year;
    protected int pageCount;

    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }
    public abstract String toString();

}
