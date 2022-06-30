import { Applicant } from "./Applicant";
export class AdmissionDTO{

    admissionId:number;
    courseName:string;
    applicant:Applicant;

    constructor(admissionId:number,courseName:string,applicant:Applicant){
        this.admissionId=admissionId;
        this.courseName=courseName;
        this.applicant=applicant;
    }
}