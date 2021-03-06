import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AdmissionDTO } from 'src/models/AdmissionDTO';
import { Applicant } from 'src/models/Applicant';


@Injectable({
  providedIn: 'root'
})

export class ApplicantService {
  private baseURL = "http://localhost:8590/universityCourseApp/";
  constructor(private httpClient: HttpClient) { }


  addApplicant(applicant: Applicant) {
    console.log(applicant);
    return this.httpClient.post(this.baseURL + "ApplicantRegistration", applicant);
  }

  updateApplicant(applicant: Applicant) {
    console.log(applicant);
    return this.httpClient.put(this.baseURL + "UpdateApplicant", applicant);
  }

  viewApplicantById() {
    return this.httpClient.get(this.baseURL + "ViewApplicant/" + sessionStorage.getItem("Applicant_id") );
    
  }

  viewApplicantDetails(applicantId) {
    return this.httpClient.get(this.baseURL + "ViewApplicant/" + sessionStorage.getItem("Applicant_id") );
    
  }

  
  deleteApplicant(applicant){
    const options={body: applicant};
    return this.httpClient.delete(this.baseURL + "DeleteApplicant" ,options)
  }

  logOut() {
    sessionStorage.removeItem("username");
    sessionStorage.clear();
  }

  viewApplicantByStatus(status:string){
    return this.httpClient.get<AdmissionDTO>(this.baseURL + "ViewAllApplicantsByStatus/"+status.toUpperCase());
  }
}




