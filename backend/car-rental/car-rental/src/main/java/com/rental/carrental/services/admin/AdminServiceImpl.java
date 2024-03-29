package com.rental.carrental.services.admin;

import com.rental.carrental.dto.CarDto;
import com.rental.carrental.entity.Car;
import com.rental.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CarRepository carRepository;

    @Override
    public boolean postCar(CarDto carDto) {
        Car car = new Car();
        System.out.println(carDto.toString());
        try {
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());
            car.setPrice(carDto.getPrice());
            car.setDate(carDto.getYear());
            car.setType(carDto.getType());
            car.setImage(carDto.getImg().getBytes());
            carRepository.save(car);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car> car= carRepository.findById(id);
        return car.map(Car::getCarDto).orElse(null);
    }

    @Override
    public boolean updateCar(Long id, CarDto carDto) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isPresent()){
            Car car = new Car();
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());
            car.setPrice(carDto.getPrice());
            car.setDate(carDto.getYear());
            car.setType(carDto.getType());
            carRepository.save(car);
            return true;
        }
        else {
            return false;
        }
    }
}
