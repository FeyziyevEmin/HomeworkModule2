package lesson9;

import org.example.lesson_9.HommeWork_9.Book;
import org.example.lesson_9.HommeWork_9.BorrowRecord;
import org.example.lesson_9.HommeWork_9.Main;
import org.example.lesson_9.HommeWork_9.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LibraryRecommendationTest {
    Main main;

    @BeforeEach
    void setUP() {
        main = new Main();
    }

    @Test
    void recommendBook_ReturnsEmpty_WhenNoBorrowHistory() {
        User user = new User("Emin", 20, new ArrayList<>());

        List<Book> allBooks = List.of(
                new Book("Elektrik cerayanlari", "Nikola Tesla", "Elmi", 2000, 4.5, true)
        );

        Optional<Book> result = main.recommendBook(user, allBooks);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void recommendBook_ReturnsAlternativeBook_SameCategory() {
        Book b1 = new Book("Clean Code", "Robert Martin", "Elmi", 2008, 4.7, true);
        Book b2 = new Book("Effective Java", "Joshua Bloch", "Elmi", 2018, 4.9, true);

        User user = new User("Emin", 25, List.of(
                new BorrowRecord(b1, LocalDate.of(2025, 1, 10), null)
        ));

        List<Book> allBooks = List.of(b1, b2);

        Optional<Book> result = main.recommendBook(user, allBooks);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(b2, result.get());
    }

    @Test
    void recommendBook_Empty_WhenNoSameCategoryBook() {
        Book last = new Book("1984","Orwell","Bedii",1949,4.9,true);
        Book other = new Book("Clean Code","Martin","Elmi",2008,4.7,true);

        User user = new User("Emin",20,List.of(
                new BorrowRecord(last,LocalDate.of(2025,5,10),null)
        ));

        List<Book> allBook = List.of(last, other);

        Optional<Book> result = main.recommendBook(user,allBook);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void recommendBook_ChoosesMostRecentBorrowRecord(){
        Book b1 = new Book("Java","X","Elmi",2000,4.5,true);
        Book b2 = new Book("Clean Code","Y","Elmi",2008,4.7,true);
        Book alternative = new Book("Effective Java","Z","Elmi",2018,4.9,true);

        User user = new User("Aydin",22,List.of(
                new BorrowRecord(b1, LocalDate.of(2025,1,10),null),
                new BorrowRecord(b2,LocalDate.of(2025,3,15),null)
        ));

        List<Book> allBook = List.of(b1,b2,alternative);

        Optional<Book> result = main.recommendBook(user,allBook);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(alternative,result.get());
    }

    @Test
    void recommendBook_ShouldNotReturnSameBook(){
        Book last = new Book("Clean Code","Martin","ELmi",2008,4.7,true);
        Book sameCategory = new Book("Effective Java","Bloch","Elmi",2018,4.9,true);

        User user =new User("Emin",20,List.of(
                new BorrowRecord(last,LocalDate.of(2025,2,1),null)
        ));

        List<Book> allBook = List.of(last,sameCategory);

        Optional<Book> result = main.recommendBook(user,allBook);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertNotEquals(last,result.get());

    }
}
