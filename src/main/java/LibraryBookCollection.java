import java.util.*;

public class LibraryBookCollection {
    private List<String> books = new ArrayList<String>();
    private Set<String> bookTitles = new HashSet<String>();

    public LibraryBookCollection() {
        books = new ArrayList<>();
        bookTitles = new HashSet<>();
    }

    //add book to collection
    //return false if duplicate

    public boolean addBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty");
        }

        String normalizedTitle = title.trim();
        if (bookTitles.contains(normalizedTitle)) {
            return false;
        }

        books.add(normalizedTitle);
        bookTitles.add(normalizedTitle);
        return true;
    }

    //Books in insertion order

    public List<String> getAllBooks() {
        return new ArrayList<>(books);
    }

    //get book by position

    public String getBookByPosition(int position) {
        if (position < 0 || position >= books.size()) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        return books.get(position);
    }

    //add a book in specified position

    public boolean addBookAtPosition(String title, int position) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty");
        }

        if (position < 0 || position > books.size()) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        String normalizedTitle = title.trim();
        if (bookTitles.contains(normalizedTitle)) {
            return false;
        }

        books.add(position, normalizedTitle);
        bookTitles.add(normalizedTitle);
        return true;
    }

    //remove book by title

    public boolean removeBookByTitle(String title) {
        if (title == null) {
            return false;
        }

        String normalizedTitle = title.trim();
        boolean removed = books.remove(normalizedTitle);
        if (removed) {
            bookTitles.remove(normalizedTitle);
        }
        return removed;
    }

    //Sorted list in alphabetic order

    public List<String> getSortedBooks() {
        List<String> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks);
        return sortedBooks;
    }

    //size of collection

    public int getSize() {
        return books.size();
    }

    //check if collection is empty

    public boolean isEmpty() {
        return books.isEmpty();
    }

   //clear books from collection
    public void clear() {
        books.clear();
        bookTitles.clear();
    }
}

