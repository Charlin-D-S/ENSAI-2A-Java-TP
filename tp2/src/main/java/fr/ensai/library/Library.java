package fr.ensai.library;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Represents a library.
 */
public class Library {
    private String name;

    private List<Item> items;
    //private List<Loan> activeLoans;
    //private List<Loan> completedLoans;
    /**
     * Constructs a new Book object.
     */

    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }
    /**
     * addIem(Item item): Adds a book to the library’s collection
     */
    public void addIem(Item item) {
        items.add(item);
    }
    /**
     * displayBooks()
     * print all books of the library
     * use toString() method from Book class
     * or print a message if there is no book
     */
    public void displayItems(){
        String message = "";
        for ( Item item : items){
            message = message + item.toString() +"\n";
        }
        if (message.isEmpty()){
            System.out.println("there is no book in the library");
        } else{
            System.out.println("Voici la liste des items de la library " +name + " :\n" +message);
        }
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     *
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName,0,"NAN");
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addIem(book);
                }
            }
        } catch (

                IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

