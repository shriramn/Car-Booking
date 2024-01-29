import { Component } from '@angular/core';
import { StorageService } from './auth/services/storage/storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'car-rental';

  isCustomerLoggedIn:boolean= StorageService.isCustomerLoggedIn();
  isAdminLoggedIn:boolean= StorageService.isAdminLoggedIn();

  constructor(private router:Router){}
  
  ngOnInit(){
    this.router.events.subscribe(event =>{
      if(event.constructor.name === 'NavigationEnd'){
        this.isAdminLoggedIn= StorageService.isAdminLoggedIn();
        this.isCustomerLoggedIn= StorageService.isCustomerLoggedIn();
        
      }
    })
  }

  logOut(){
    StorageService.logOut();
    this.router.navigateByUrl('/login');
  }

}
