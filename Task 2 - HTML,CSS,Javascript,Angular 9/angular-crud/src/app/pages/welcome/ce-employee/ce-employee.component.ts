import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/models/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-ce-employee',
  templateUrl: './ce-employee.component.html',
  styleUrls: ['./ce-employee.component.scss']
})
export class CeEmployeeComponent implements OnInit{

  id: any;
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute){

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    console.log(this.id);
    
    //get employee by id

  }

  getEmployeeById(){
    this.employeeService.getEmployeeById(this.id).subscribe({
      next: (data)=>{
        this.employee = data;
      },
      error: (err) =>{
        console.log(err);
        
      }
    });
  }
}
