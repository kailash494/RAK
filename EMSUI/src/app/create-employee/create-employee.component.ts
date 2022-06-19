import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
// import { MAT_DATE_LOCALE } from '@angular/material/core';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css'],
  providers: [
    // { provide: MAT_DATE_LOCALE, useValue: 'en-GB' }
  ]
})
export class CreateEmployeeComponent implements OnInit {

  
  employee: Employee = new Employee();
  departments!: Department[];

  constructor(private departmentService: DepartmentService, private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
     this.getDepartment();

  }
  private getDepartment() {
    this.departmentService.getDepartmentList().subscribe(data => {
      this.departments = data;
      console.log(data);
    });
  }

  saveEmployee() {
    console.log(this.employee);
    this.employeeService.createEmployee(this.employee).subscribe(data => {
      console.log(data);
      this.goToEmployeeList();
    },
      error => console.log(error));
  }
  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }
  onSubmit() {
    console.log(this.employee);
    this.saveEmployee();
  }


}
