import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from './department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

    
  private baseURL = "http://localhost:8080/api/v1/department/";

  constructor(private httpClient: HttpClient) { }

  getDepartmentList(): Observable<Department[]> {
    return this.httpClient.get<Department[]>(`${this.baseURL}`);
  }

}
