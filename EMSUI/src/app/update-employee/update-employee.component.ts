import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id!: number;
  employee: Employee = new Employee();
  departments!: Department[];
  constructor(private departmentService: DepartmentService, private employeService: EmployeeService, private router: Router, private route: ActivatedRoute) { }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.log(error));
    this.getDepartment();
  }
  private getDepartment() {
    this.departmentService.getDepartmentList().subscribe(data => {
      this.departments = data;
      console.log(data);
    });
  }
  onSubmit() {
    console.log(this.employee);
  
    this.employeService.updateEmployee(this.id, this.employee).subscribe(data => {
      this.goToEmployeeList();
    }, error => console.log(error));

  }
  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }


}
