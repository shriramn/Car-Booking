import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AminDashboardComponent } from './components/amin-dashboard/amin-dashboard.component';
import { PostCarComponent } from './components/post-car/post-car.component';

const routes: Routes = [
  {path: 'dashboard', component: AminDashboardComponent},
  {path: 'car', component: PostCarComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
