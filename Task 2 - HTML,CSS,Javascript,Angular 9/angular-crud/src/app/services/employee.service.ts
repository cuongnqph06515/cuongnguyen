import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../models/Employee.model";

@Injectable({
    providedIn: "root"
})
export class EmployeeService{
    private url = "https://63998d9e29930e2bb3d6b77d.mockapi.io";

    private employeeJson = [{"name":"cuong nguyen","mail":"mail 1","address":"address 1","phone":"phone 1","gender":true,"id":"1"},{"name":"quyen","mail":"quyen nodo","address":"address 2","phone":"phone 2","gender":true,"id":"2"},{"name":"hoang anh","mail":"mail@gmail.com","address":"address 3","phone":"0392386891","gender":false,"id":"3"},{"name":"name 4","mail":"mail 4","address":"address 4","phone":"phone 4","gender":false,"id":"4"},{"name":"name 5","mail":"mail 5","address":"address 5","phone":"phone 5","gender":false,"id":"5"},{"name":"name 6","mail":"mail 6","address":"address 6","phone":"phone 6","gender":false,"id":"6"},{"name":"name 10","mail":"mail 10","address":"address 10","phone":"phone 10","gender":false,"id":"10"},{"name":"name 11","mail":"mail 11","address":"address 11","phone":"phone 11","gender":false,"id":"11"},{"name":"name 12","mail":"mail 12","address":"address 12","phone":"phone 12","gender":false,"id":"12"},{"name":"name 13","mail":"mail 13","address":"address 13","phone":"phone 13","gender":false,"id":"13"},{"name":"name 14","mail":"mail 14","address":"address 14","phone":"phone 14","gender":false,"id":"14"},{"name":"name 15","mail":"mail 15","address":"address 15","phone":"phone 15","gender":false,"id":"15"},{"name":"name 16","mail":"mail 16","address":"address 16","phone":"phone 16","gender":false,"id":"16"},{"name":"name 17","mail":"mail 17","address":"address 17","phone":"phone 17","gender":false,"id":"17"},{"name":"name 18","mail":"mail 18","address":"address 18","phone":"phone 18","gender":false,"id":"18"},{"name":"name 19","mail":"mail 19","address":"address 19","phone":"phone 19","gender":false,"id":"19"},{"name":"name 20","mail":"mail 20","address":"address 20","phone":"phone 20","gender":false,"id":"20"},{"name":"name 21","mail":"mail 21","address":"address 21","phone":"phone 21","gender":false,"id":"21"},{"name":"name 22","mail":"mail 22","address":"address 22","phone":"phone 22","gender":false,"id":"22"},{"name":"name 23","mail":"mail 23","address":"address 23","phone":"phone 23","gender":false,"id":"23"},{"name":"name 24","mail":"mail 24","address":"address 24","phone":"phone 24","gender":false,"id":"24"},{"name":"name 25","mail":"mail 25","address":"address 25","phone":"phone 25","gender":false,"id":"25"},{"name":"name 26","mail":"mail 26","address":"address 26","phone":"phone 26","gender":false,"id":"26"},{"name":"name 27","mail":"mail 27","address":"address 27","phone":"phone 27","gender":false,"id":"27"},{"name":"name 28","mail":"mail 28","address":"address 28","phone":"phone 28","gender":false,"id":"28"},{"name":"name 29","mail":"mail 29","address":"address 29","phone":"phone 29","gender":false,"id":"29"},{"name":"name 30","mail":"mail 30","address":"address 30","phone":"phone 30","gender":false,"id":"30"},{"name":"name 31","mail":"mail 31","address":"address 31","phone":"phone 31","gender":false,"id":"31"},{"name":"name 32","mail":"mail 32","address":"address 32","phone":"phone 32","gender":false,"id":"32"},{"name":"name 33","mail":"mail 33","address":"address 33","phone":"phone 33","gender":false,"id":"33"},{"name":"name 34","mail":"mail 34","address":"address 34","phone":"phone 34","gender":false,"id":"34"},{"name":"name 35","mail":"mail 35","address":"address 35","phone":"phone 35","gender":false,"id":"35"},{"name":"name 36","mail":"mail 36","address":"address 36","phone":"phone 36","gender":false,"id":"36"},{"name":"name 37","mail":"mail 37","address":"address 37","phone":"phone 37","gender":false,"id":"37"},{"name":"name 38","mail":"mail 38","address":"address 38","phone":"phone 38","gender":false,"id":"38"},{"name":"name 39","mail":"mail 39","address":"address 39","phone":"phone 39","gender":false,"id":"39"},{"name":"cdscds","mail":"cdscdscds@gmail.com","address":"cdscds","phone":"0392386891","gender":true,"id":"40"},{"name":"cdscds","mail":"cdscdscds@gmail.com","address":"cdscds","phone":"0392386891","gender":true,"id":"41"},{"name":"cdscds","mail":"cdscdscds@gmail.com","address":"cdscds","phone":"0392386891","gender":true,"id":"42"}]
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