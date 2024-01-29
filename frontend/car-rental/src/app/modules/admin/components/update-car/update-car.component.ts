import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-car',
  templateUrl: './update-car.component.html',
  styleUrls: ['./update-car.component.scss']
})
export class UpdateCarComponent implements OnInit {
  carId: number = this.activatedRoute.snapshot.params["id"];
  existingImage: string | null = null;
  updateForm!: FormGroup;
  listOfBrands = ["MARUTI", "TOYOTA", "TATA", "HYUNDAI"];
  listOfType = ["Petrol", "HYBRID", "EV"]
  listOfColor = ["Black", "BLUE", "RED", "White"]
  listOfTransmission = ["Manual", " Automatic"];

  constructor(private adminService: AdminService,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.updateForm = this.fb.group({
      name: [null, Validators.required],
      brand: [null, Validators.required],
      type: [null, Validators.required],
      color: [null, Validators.required],
      transmission: [null, Validators.required],
      price: [null, Validators.required],
      description: [null, Validators.required],
      year: [null, Validators.required]
    })
    this.getCarById();
  }

  getCarById() {
    this.adminService.getCarById(this.carId).subscribe(data => {
      const carDto = data;
      this.existingImage = 'data:image/jpeg;base64,' + data.returnedImage;
      console.log(carDto)
      console.log(this.existingImage)
      this.updateForm.patchValue(carDto);
    })
  }

}
