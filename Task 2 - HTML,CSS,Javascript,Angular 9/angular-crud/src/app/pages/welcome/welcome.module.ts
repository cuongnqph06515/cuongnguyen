import { NgModule } from '@angular/core';
import { NzTableModule } from 'ng-zorro-antd/table';
import { WelcomeRoutingModule } from './welcome-routing.module';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { WelcomeComponent } from './welcome.component';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';


@NgModule({
  imports: [WelcomeRoutingModule,
    NzTableModule,
    NzDividerModule,
  CommonModule],
  declarations: [WelcomeComponent],
  exports: [WelcomeComponent]
})
export class WelcomeModule { }
