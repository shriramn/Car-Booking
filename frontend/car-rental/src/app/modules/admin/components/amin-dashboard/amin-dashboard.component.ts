import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-amin-dashboard',
  templateUrl: './amin-dashboard.component.html',
  styleUrls: ['./amin-dashboard.component.scss']
})
export class AminDashboardComponent implements OnInit {

  cars: any=[];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.getAllCars();
  }

  getAllCars(){
    return this.adminService.getAllCars().subscribe(data=>{
      console.log(data);
      data.forEach(element => {
        element.processedImg ='data:image/jpeg;base64,'+element.returnedImage;
        this.cars.push(element);
      });
    })

  }

}
