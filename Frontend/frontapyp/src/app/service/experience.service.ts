import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Experience } from '../models/experience.model';

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  private apiServerUrl=environment.urlBase;

  constructor(private http: HttpClient) { }

    public getExperience(): Observable<Experience[]> {
      return this.http.get<Experience[]>(`${this.apiServerUrl}/experience/all`);
    }

    public getExperienceById(idExperience: number):Observable<Experience> {
      return this.http.get<Experience>(`${this.apiServerUrl}/experience/${idExperience}`);
    }

    public addExperience(experience: Experience):Observable<any>{
      return this.http.post<any>(`${this.apiServerUrl}/experience/add`, experience);
    }
  
    public editExperience(experience: Experience):Observable<Experience>{      
      return this.http.put<Experience>(`${this.apiServerUrl}/experience/edit`, experience);
    }
  
    public deleteExperience(idExperience: number):Observable<void>{      
      return this.http.delete<void>(`${this.apiServerUrl}/experience/delete/${idExperience}`);
    } 
  }

