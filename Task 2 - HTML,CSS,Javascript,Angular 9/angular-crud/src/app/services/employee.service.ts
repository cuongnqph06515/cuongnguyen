import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../models/Employee.model";

@Injectable({
    providedIn: "root"
})
export class EmployeeService{
    private url = "https://63998d9e29930e2bb3d6b77d.mockapi.io";

    constructor(private http: HttpClient){

    }

    getAllEmployee(): Observable<any>{
        return this.http.get<Employee>(`${this.url}/employee`);
    }

    getEmployeeById(id: number): Observable<any>{
        return this.http.get<Employee>(`${this.url}/employee/${id}`)
    }

    addEmployee(data: Employee):Observable<any>{
        return this.http.post(`${this.url}/employee`, data);
    }

    updateEmployee(data: Employee):Observable<any>{
        return this.http.put(`${this.url}/employee/${data.id}`, data)
    }

    deleteEmployee(id: any){
        return this.http.delete(`${this.url}/employee/${id}`)
    }

}