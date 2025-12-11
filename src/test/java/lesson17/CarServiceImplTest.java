package lesson17;

import org.example.lesson_17.Practice.Exception.CarNotFoundException;
import org.example.lesson_17.Practice.dto.CarDTO;
import org.example.lesson_17.Practice.model.Car;
import org.example.lesson_17.Practice.repository.CarRepository;
import org.example.lesson_17.Practice.service.CarService;
import org.example.lesson_17.Practice.service.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;


    @Test
    void getCarById_success() {
        Mockito.when(carRepository.getCarById(1))
                .thenReturn(Optional.of(new Car("red",100)));
        CarDTO.CarDto actual = carService.getCarById(1);
        CarDTO.CarDto expected = new CarDTO.CarDto("red",100);
        Assertions.assertEquals(expected.getColor(),actual.getColor());
        Assertions.assertEquals(expected.getSpeed(),actual.getSpeed());
    }

    @Test
    void getCarById_throw() {
        Mockito.when(carRepository.getCarById(1))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(CarNotFoundException.class, () -> carService.getCarById(1));
    }


}
