import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Employee } from 'src/app/models/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-ce-employee',
  templateUrl: './ce-employee.component.html',
  styleUrls: ['./ce-employee.component.scss']
})
export class CeEmployeeComponent implements OnInit{

  employeeForm!: FormGroup;
  id: any;
  isSubmit!: boolean;
  employee!: Employee[];
  constructor(private employeeService: EmployeeService, 
              private route: ActivatedRoute,
              private fb: FormBuilder,
              private router: Router,
              private toatrService: ToastrService){
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");

    this.employeeForm = this.fb.group({
      name: ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(51)])],
      mail: ['', Validators.compose([Validators.required,Validators.maxLength(100), Validators.pattern(/^[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,3}/)])],
      address: ['', Validators.compose([Validators.required, Validators.maxLength(500)])],
      phone: ['', Validators.compose([Validators.required, Validators.pattern(/((09|03|07|08|05)+([0-9]{8})\b)/)])],
      gender: ['', Validators.required],
    });

    if(this.id != 0){
      //get employee by id
      this.getEmployeeById(this.id);
    }
  }

  getEmployeeById(id: any){
    this.employeeService.getEmployeeById(id).subscribe({
      next: (data)=>{
        this.employeeForm.patchValue({
          name: data.name,
          mail: data.mail,
          address: data.address,
          phone: data.phone,
          gender: data.gender,
        });
      },
      error: (err) =>{
        console.log(err);
      }
    });
  }

  onSubmit(){
    this.isSubmit = true;
    if(this.employeeForm.valid){
      this.createEditEmployee();
    }
  }
  createEditEmployee(){
    let employee: Employee = new Employee();
    employee.name = this.employeeForm.value.name;
    employee.mail = this.employeeForm.value.mail;
    employee.address = this.employeeForm.value.address;
    employee.phone = this.employeeForm.value.phone;
    employee.gender = this.employeeForm.value.gender;
    if(this.id == 0){
      employee.id = Math.ceil(Math.random()*50);
      
      this.employeeService.addEmployee(employee).subscribe({
        next: () =>{
          this.router.navigateByUrl('/welcome');
          this.showMessageSuccess("Thêm nhân viên thành công", 3000);
        },
        error: (err) =>{
          console.log(err);
        }
      });
    }else{
      employee.id = this.id;
      this.employeeService.updateEmployee(employee).subscribe({
        next: () =>{
          this.router.navigateByUrl('/welcome');
          this.showMessageSuccess("Cập nhật thành công", 3000);
        },
        error: (err) =>{
          console.log(err);
        }
      });
    }
  }

  showMessageSuccess(message: string, time: number){
    this.toatrService.success(message, '', {
      timeOut: time
    });
  }
  showMessageError(message: string, time: number){
    this.toatrService.error(message, '', {
      timeOut: time
    });
  }
}
