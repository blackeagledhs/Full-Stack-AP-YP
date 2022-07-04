import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Project } from '../models/project.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private apiServerUrl=environment.urlBase;

  constructor(private http: HttpClient) {

    public getProject():Observable<Project[]> {
      return this.http.get<Project[]>('${this.apiServerUrl}/project/all');
    }
  
    public getProjectById(idProject: number):Observable<Project> {
      return this.http.get<Project>(`${this.apiServerUrl}/project/${idProject}`);
    }

    public addProject(project: Project):Observable<any>{
      return this.http.post<any>('${this.apiServerUrl}/project/add', project);
    }
  
    public editProject(project: Project):Observable<Project>{
      let idProject = project.idproject;
      return this.http.put<Project>('${this.apiServerUrl}/project/edit', project);
    }
  
    public deleteProject(idProject: number):Observable<void>{
      let id = idProject;
      return this.http.delete<void>('${this.apiServerUrl}/project/delete/${idContact}');
    }
   }
}
