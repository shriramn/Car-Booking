package com.rental.carrental.controller;

import com.rental.carrental.dto.CarDto;
import com.rental.carrental.entity.Car;
import com.rental.carrental.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/car")
    public ResponseEntity<?> postCar(@ModelAttribute CarDto carDto){
        boolean success = adminService.postCar(carDto);
        if(success){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars(){
        System.out.println(adminService.getAllCars());
        return ResponseEntity.ok(adminService.getAllCars());
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        adminService.deleteCar(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id){
       CarDto carDto = adminService.getCarById(id);
       return  ResponseEntity.ok(carDto);
    }

    @PostMapping("/car/{id}")
    public ResponseEntity<?> updateCarById(@PathVariable Long id, @ModelAttribute CarDto carDto){
        try{
            boolean success=  adminService.updateCar(id, carDto);
            if(success) return ResponseEntity.status(HttpStatus.OK).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


        }
    }
}
