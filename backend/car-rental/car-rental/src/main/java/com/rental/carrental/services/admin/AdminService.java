package com.rental.carrental.services.admin;

import com.rental.carrental.dto.CarDto;

import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto);

    List<CarDto> getAllCars();

    void deleteCar(Long id);
}
