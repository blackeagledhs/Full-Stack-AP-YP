import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Skill } from '../models/skill.model';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private apiServerUrl=environment.urlBase;

  constructor(private http: HttpClient) { }
    
    public getSkill():Observable<Skill[]> {
      return this.http.get<Skill[]>(`${this.apiServerUrl}/skill/all`);
    }

    public getSkillById(idSkill: number):Observable<Skill> {
      return this.http.get<Skill>(`${this.apiServerUrl}/skill/${idSkill}`);
    }
  
    public addSkill(skill: Skill):Observable<any>{
      return this.http.post<any>(`${this.apiServerUrl}/skill/add`, skill);
    }
  
    public editSkill(skill: Skill):Observable<Skill>{
      let idSkill = skill.idskill;
      return this.http.put<Skill>(`${this.apiServerUrl}/skill/edit`, skill);
    }
  
    public deleteSkill(idSkill: number):Observable<void>{
      let id = idSkill;
      return this.http.delete<void>(`${this.apiServerUrl}/skill/delete/${idSkill}`);
    }
   }

