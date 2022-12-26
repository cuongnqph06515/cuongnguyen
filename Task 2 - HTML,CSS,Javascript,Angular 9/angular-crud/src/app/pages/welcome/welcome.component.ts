import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Employee } from 'src/app/models/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit{

  listEmployee: Employee[]=[];
  constructor(private employeeService: EmployeeService, private toatrService: ToastrService){
  }

  ngOnInit(): void {
    this.getAllUser();
  }

  getAllUser(){
   this.employeeService.getAllEmployee().subscribe({
    next: (data)=>{
      this.listEmployee = data;
      console.log(data);
    },
    error: (err)=>{
      console.log(err);
    }
   });
  }

  deleteEmployee(id : any){
    this.employeeService.deleteEmployee(id).subscribe({
      next: () =>{
          this.listEmployee = this.listEmployee.filter(data => data.id !== id);
          this.showMessageSuccess("Xóa nhân viên thành công", 3000);
      }
      ,error: (err) =>{
          console.log(err);
          
      }
    });
  }

  showMessageSuccess(message: string, time: number){
    this.toatrService.success(message, '', {
      timeOut: time
    });
  }

}
