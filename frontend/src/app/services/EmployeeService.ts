import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import{env} from "../env/env.test";
import { Employee } from "../models/Employee";
import { HttpClient } from "@angular/common/http";


@Injectable({
    providedIn:'root',

})
export class EmployeeService{
    private baseUrl=`${env.baseUrl}/employee`

    constructor(private http:HttpClient){}

    getAll():Observable<Employee[]>{
        return this.http.get<Employee[]>(`${this.baseUrl}/get-all`)

    }
register(data:any) {
    return this.http.post(`${this.baseUrl}/register`, data, {
      responseType: 'text',
    });
  }




}
