import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CeEmployeeComponent } from './ce-employee/ce-employee.component';
import { WelcomeComponent } from './welcome.component';

const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'eece-employ/:id', component: CeEmployeeComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WelcomeRoutingModule { }
