import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees!: Employee[];
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private router: Router, public datepipe: DatePipe) {

  }

  ngOnInit(): void {
    this.getEmployees();

  }
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe((data : any) => {
      this.employees = data;
      for (let i = 0; i < this.employees.length; i++) {
        this.employees[i].doj =  this.datepipe.transform(this.employees[i].doj, 'dd/MM/yyyy');
      }
      console.log(this.employees);
    });
  }


  updateEmployee(id: number) {
    this.router.navigate(["update-employee", id]);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployees();
    });
  }

  viewEmployee(id: number) {
    this.router.navigate(["employee-details", id]);
  }
}
