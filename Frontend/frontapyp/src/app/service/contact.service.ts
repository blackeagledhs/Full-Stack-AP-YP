import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Contact } from '../models/contact.model';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private apiServerUrl=environment.urlBase;

  constructor(private http: HttpClient) {}

    public getContact():Observable<Contact[]> {
      return this.http.get<Contact[]>(`${this.apiServerUrl}/contact/all`);
    }

    public getContactById(idContact: number):Observable<Contact> {
      return this.http.get<Contact>(`${this.apiServerUrl}/contact/${idContact}`);
    }
  
    public addContact(contact: Contact):Observable<any>{
      return this.http.post<any>(`${this.apiServerUrl}/contact/add`, contact);
    }
  
    public editContact(contact: Contact):Observable<Contact>{
      return this.http.put<Contact>(`${this.apiServerUrl}/contact/edit`, contact);
    }
  
    public deleteContact(idContact: number):Observable<void>{
      return this.http.delete<void>(`${this.apiServerUrl}/contact/delete/${idContact}`);
    }
  }

