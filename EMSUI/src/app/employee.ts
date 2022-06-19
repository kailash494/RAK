import { Department } from "./department";

export class Employee {

    id!: number;
    eNo!: number;
    employeeName!:string;
    dCode!:string;
    doj!:any;
    salary!:string;
    department: Department = new Department();
}
