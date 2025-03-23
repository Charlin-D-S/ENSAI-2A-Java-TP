package fr.ensai.library;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        System.out.println(fellowshipOfTheRing.toString());

        Library library = new Library("ENSAI Biblio");
        Magazine magazine = new Magazine("1234-5678", "The New Yorker", 1, 2019, 100);
        Magazine magazine2 = new Magazine("1000-5678", "The ENSAI", 123, 1999, 20);
        library.addIem(magazine);
        library.addIem(magazine2);
        library.loadBooksFromCSV("books.csv");
        library.displayItems();
    }



}