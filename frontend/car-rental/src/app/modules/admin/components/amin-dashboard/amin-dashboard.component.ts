import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AdminService } from '../../services/admin.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-amin-dashboard',
  templateUrl: './amin-dashboard.component.html',
  styleUrls: ['./amin-dashboard.component.scss']
})
export class AminDashboardComponent {

  cars: any = [];

  constructor(private adminService: AdminService,
    private message: NzMessageService, private router:Router) { }

  ngOnInit(): void {

    this.getAllCars();
  }

  getAllCars() {
    this.cars=[];
    return this.adminService.getAllCars().subscribe(data => {
      console.log(data);
      data.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImage;
        this.cars.push(element);
      });
    })

  }

  deleteCar(id: number) {
    console.log(id)
    this.adminService.deleteCar(id).subscribe((data) => {
      this.getAllCars();
      this.message.success("Car deleted successfully", { nzDuration: 5000 })
    });

  }


}
