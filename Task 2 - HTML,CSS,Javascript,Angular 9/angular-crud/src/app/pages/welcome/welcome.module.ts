import { NgModule } from '@angular/core';
import { NzTableModule } from 'ng-zorro-antd/table';
import { WelcomeRoutingModule } from './welcome-routing.module';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NzCardModule } from 'ng-zorro-antd/card';
import { WelcomeComponent } from './welcome.component';
import { CommonModule } from '@angular/common';
import { CeEmployeeComponent } from './ce-employee/ce-employee.component';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzRadioModule } from 'ng-zorro-antd/radio';


@NgModule({
  imports: [WelcomeRoutingModule,
    NzTableModule,
    NzDividerModule,
    CommonModule,
    NzCardModule,
    NzButtonModule,
    NzFormModule,
    NzInputModule,
    NzRadioModule],
  declarations: [WelcomeComponent, CeEmployeeComponent],
  exports: [WelcomeComponent]
})
export class WelcomeModule { }
