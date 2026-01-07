import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryBookCollectionTest {
    private LibraryBookCollection library;

    @BeforeEach
    public void setUp() {
        library = new LibraryBookCollection();
    }

    @Test
    void collectionNotNullAfterInstantiation() {
        assertNotNull(library);
        assertNotNull(library.getAllBooks());
    }

    @Test
    void sizeShouldBeCorrectAfterAddingBook() {
        library.addBook("Archivo de las tormentas");
        library.addBook("La Biblia");
        assertEquals(2, library.getAllBooks().size());

    }

    @Test
    void addBookAtSpecificPositionShouldModifyCollectionSize() {
        library.addBook("Archivo de las tormentas");
        library.addBook("La Biblia");

        boolean added = library.addBookAtPosition("Mistborn", 1);

        assertTrue(added);
        assertEquals(3, library.getSize());
        assertEquals("Archivo de las tormentas", library.getBookByPosition(0));
        assertEquals("Mistborn", library.getBookByPosition(1));
        assertEquals("La Biblia", library.getBookByPosition(2));
    }

    @Test
    void removeBookAtSpecificPositionShouldReduceCollectionSize() {
        library.addBook("Archivo de las tormentas");
        library.addBook("La Biblia");
        library.addBook("Mistborn");

        int initialSize = library.getSize();
        boolean removed = library.removeBookByTitle("Archivo de las tormentas");
        int finalSize = library.getSize();

        assertTrue(removed);
        assertEquals(initialSize - 1, finalSize);
        assertEquals(2, library.getSize());
    }

    //part 1
    @Test
    void sortedListShouldReturnBooksAlphabetically() {
        library.addBook("Archivo de las tormentas");
        library.addBook("La Biblia");
        library.addBook("Mistborn");
        library.addBook("Mundodisco");

        var sortedBooks = library.getSortedBooks();

        assertEquals("Archivo de las tormentas", sortedBooks.get(0));
        assertEquals("La Biblia", sortedBooks.get(1));
        assertEquals("Mistborn", sortedBooks.get(2));
        assertEquals("Mundodisco", sortedBooks.get(3));
    }

    //part 2
    @Test
    void originalCollectionShouldNotBeModifiedAfterSorting() {
        library.addBook("La Biblia");
        library.addBook("Archivo de las tormentas");

        var originalBooksBefore = library.getAllBooks();
        var sortedBooks = library.getSortedBooks();
        var originalBooksAfter = library.getAllBooks();

        assertNotEquals(originalBooksBefore, sortedBooks);
        assertEquals(originalBooksBefore, originalBooksAfter);
    }

    @Test
    void noDuplicateBookTitles(){
        boolean firstAdd = library.addBook("Archivo de las tormentas");
        boolean secondAdd = library.addBook("Archivo de las tormentas");
        boolean thirdAdd = library.addBook("    Archivo de las tormentas     ");

        assertTrue(firstAdd);
        assertFalse(secondAdd);
        assertFalse(thirdAdd);
        assertEquals(1, library.getSize());
    }


}