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

    getAllUser(): Observable<any>{
        return this.http.get<Employee>(`${this.url}/employee`);
    }
    getUserById(id: number): Observable<any>{
        return this.http.get<Employee>(`${this.url}/employee/${id}`)
    }
}