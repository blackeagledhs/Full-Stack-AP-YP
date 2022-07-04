import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl=environment.urlBase;

  constructor(private http: HttpClient) { }
    
    public getUser(): Observable<User>{
      return this.http.get<User>(`${this.apiServerUrl}/user/getbyid/1`);
    };
  
    public editUser(user: User):Observable<any>{
      return this.http.put<any>(`${this.apiServerUrl}/user/edit/1`, user);
    }
  
}
