package org.example.lesson_17.Practice.service;

import org.example.lesson_17.Practice.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO.CarDto> getCars();

    CarDTO.CarDto getCarById(int id);

    void addCar(CarDTO.CarDto car);

    void deleteCarById(int id);

    void updateCar(int id, CarDTO.CarDto carDto);

}
