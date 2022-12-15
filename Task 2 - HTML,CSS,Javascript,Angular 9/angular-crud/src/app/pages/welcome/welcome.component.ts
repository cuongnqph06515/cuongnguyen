import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit{

  listEmployee: Employee[]=[];

  constructor(private employeeService: EmployeeService){

  }
  ngOnInit(): void {
    this.getAllUser();
  }


  getAllUser(){
   this.employeeService.getAllEmployee().subscribe({
    next: (data)=>{
      console.log(data);
      this.listEmployee = data;
    },
    error: (err)=>{
      console.log(err);
    }
   });
  }

}
