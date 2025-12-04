package lesson9;

import org.example.lesson_9.HommeWork_9.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LibraryRecommendationTest {
    Main main;

    @BeforeEach
    void setUP(){
        main = new Main();
    }

    @Test
    void recommendBook_returnsEmpty_WhenNoBorrowHistory(){

    }
}
