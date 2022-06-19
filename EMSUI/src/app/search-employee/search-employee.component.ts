import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css']
})
export class SearchEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  placeDetail:any;
  constructor(private employeService: EmployeeService, private router: Router) { }


  ngOnInit(): void {
  }
  onSubmit() {
    console.log(this.employee);
    console.log(this.employee);
    this.employeService.searchEmployee(this.employee).subscribe(data => {
      console.log(data);
      this.placeDetail = data;
    },
      error => this.placeDetail = error);
  }
}
