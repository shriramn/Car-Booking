package com.rental.carrental.entity;

import com.rental.carrental.dto.CarDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private String transmission;
    private String description;
    private Long price;
    private Date date;
    @Column(columnDefinition = "longblob")
    private byte[] image;

    public CarDto getCarDto(){
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setPrice(price);
        carDto.setName(name);
        carDto.setColor(color);
        carDto.setType(type);
        carDto.setBrand(brand);
        carDto.setDescription(description);
        carDto.setTransmission(transmission);
        carDto.setYear(date);
        carDto.setReturnedImage(image);
        return carDto;
    }

}
