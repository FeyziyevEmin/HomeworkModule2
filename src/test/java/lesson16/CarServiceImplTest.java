package lesson16;

import org.example.lesson_17.Practice.dto.CarDTO;
import org.example.lesson_17.Practice.model.Car;
import org.example.lesson_17.Practice.repository.CarRepository;
import org.example.lesson_16.Practice.service.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

public class CarServiceImplTest {
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;


    @Test
    void getCarById_success() {
        Mockito.when(carRepository.getCarById(1))
                .thenReturn(Optional.of(new Car("Red", 100)));
        CarDTO.CarDto actual = carService.getCarById(1);
        CarDTO.CarDto expected = new CarDTO.CarDto("Red", 100);
        Assertions.assertEquals(expected.getColor(), actual.getColor());
        Assertions.assertEquals(expected.getSpeed(), actual.getSpeed());
    }

    @Test
    void getCarById_throw() {
        Mockito.when(carRepository.getCarById(1))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(CarNotFoundException.class, () -> carService.getCarById(1));
    }


}
