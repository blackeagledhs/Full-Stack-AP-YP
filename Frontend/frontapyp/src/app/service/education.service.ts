import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Education } from '../models/education.model';

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  private apiServerUrl = environment.urlBase;

  constructor(private http: HttpClient) { }

  public getEducation(): Observable<Education[]> {
    return this.http.get<Education[]>(`${this.apiServerUrl}/education/all`);
  }
  
    public getEducationById(idEducation: number):Observable<Education> {
      return this.http.get<Education>(`${this.apiServerUrl}/education/${idEducation}`);
    }

    public addEducation(education: Education):Observable<any>{
      return this.http.post<any>(`${this.apiServerUrl}/education/add`, education);
    }
  
    public editEducation(education: Education):Observable<Education>{
      return this.http.put<Education>(`${this.apiServerUrl}/education/edit`, education);
    }
  
    public deleteEducation(idEducation: number):Observable<void>{      
      return this.http.delete<void>(`${this.apiServerUrl}/education/delete/${idEducation}`);
    }
}

