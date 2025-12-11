package org.example.lesson_17.Practice.service;

import org.example.lesson_17.Practice.Exception.CarNotFoundException;
import org.example.lesson_17.Practice.dto.CarDTO;
import org.example.lesson_17.Practice.model.Car;
import org.example.lesson_17.Practice.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDTO.CarDto> getCars() {
        return carRepository.getCars()
                .stream()
                .map(car -> CarDTO.CarDto.builder()
                        .color(car.getColor())
                        .speed(car.getSpeed())
                        .id(car.getId())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public CarDTO.CarDto getCarById(int id) {
        Car car = carRepository.getCarById(id).
                orElseThrow(() -> new CarNotFoundException("Car not found"));
        return CarDTO.CarDto.builder()
                .color(car.getColor())
                .speed(car.getSpeed())
                .id(car.getId())
                .build();
    }

    @Override
    public void addCar(CarDTO.CarDto car) {
        carRepository.saveCar(new Car(car.getColor(), car.getSpeed()));
    }

    @Override
    public void deleteCarById(int id) {
        carRepository.deleteCarById(id);
    }

    @Override
    public void updateCar(int id, CarDTO.CarDto carDto) {
        carRepository.updateCar(id, new Car(carDto.getColor(), carDto.getSpeed()));
    }
}

