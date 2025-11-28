package lesson2;

import org.example.lesson2.Practice.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.example.lesson2.Practice.Car.changeGear;

@ExtendWith(MockitoExtension.class)
public class CarTest {
    Car car;

    @BeforeEach
    void setUp(){
        car=new Car(4,100);
    }

    @Test
    void changeGearTo1(){
        Assertions.assertDoesNotThrow(()->changeGear(1));
    }

    @Test
    void changeGearTo2(){
        Assertions.assertDoesNotThrow(()->changeGear(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    void changeGearThrows(int gear){
        Assertions.assertThrows(IllegalArgumentException.class,()->Car.changeGear(gear));
    }
}
