import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { delay, Observable, of } from "rxjs";
import { Employee } from "../models/Employee.model";

@Injectable({
    providedIn: "root"
})
export class EmployeeService{
    private url = "https://63998d9e29930e2bb3d6b77d.mockapi.io";

    private listEmployee : Employee[]=[
        {name: 'cuong nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 1},
        {name: 'nam nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 2},
        {name: 'thang nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 3},
        {name: 'hanh nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 4},
        {name: 'hung nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 5},
        {name: 'manh nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 6},
        {name: 'kien nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 7},
        {name: 'cuong nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 8},
        {name: 'huong nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 9},
        {name: 'dat nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 10},
        {name: 'hien nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 11},
        {name: 'sinh nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 12},
        {name: 'tien nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 13},
        {name: 'dung nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 14},
        {name: 'du nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 15},
        {name: 'doanh nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 16},
        {name: 'duc nguyen', mail: 'mail 1', address: 'address 1', phone: 'phone 1', gender: true, id: 17}
    ];

    constructor(private http: HttpClient){
    }

    getAllEmployee(): Observable<any>{
        return of(this.listEmployee).pipe(delay(300));
        // return this.http.get<Employee>(`${this.url}/employee`);
    }

    getEmployeeById(id: number): Observable<any>{
        
        this.listEmployee.filter(item => item.id === id);
        return of(this.listEmployee[0]).pipe(delay(300));
        // return this.http.get<Employee>(`${this.url}/employee/${id}`)
    }

    addEmployee(data: Employee):Observable<any>{
        this.listEmployee.push(data);
        return of(this.listEmployee).pipe(delay(300));
        // return this.http.post(`${this.url}/employee`, data);
    }

    updateEmployee(data: Employee):Observable<any>{
        this.listEmployee[data.id] = data;
        return of(this.listEmployee).pipe(delay(300));
        // return this.http.put(`${this.url}/employee/${data.id}`, data)
    }

    deleteEmployee(id: any){
        this.listEmployee.forEach((item, index)=>{
            if(item.id === id){
                this.listEmployee.splice(index, 1);
            }
        });
        return of(this.listEmployee).pipe(delay(300));
        // return this.http.delete(`${this.url}/employee/${id}`);
    }
}