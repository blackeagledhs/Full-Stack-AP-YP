import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Contact } from 'src/app/models/contact.model';
import { ContactService } from 'src/app/service/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  public contact: Contact[] = [];
  public editContact: Contact | undefined;
  public deleteContact: Contact | undefined;
  


  constructor(private contactService: ContactService) { }

  ngOnInit(): void {
    this.getContact();
  }

  public getContact():void {
    this.contactService.getContact().subscribe(
      data => {
        this.contact = data;
      },
      error => {
        console.log(error);
      }
    )
  }

  public onOpenModal(mode: String, contact?: Contact): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('buttoon');
    //button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addContactModal');
    } else if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteContactModal');
      this.deleteContact = contact;
    } else if (mode === 'edit') {
      button.setAttribute('data-target', '#editContactModal');
      this.editContact = contact;
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddContact(addForm: NgForm): void {
    document.getElementById('addContactModal')?.click();
    this.contactService.addContact(addForm.value).subscribe({
      next: (_response: Contact) => {
        this.getContact();
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onEditContact(contact: Contact): void {
    this.contactService.editContact(contact).subscribe(
      (response: Contact) => {
        console.log(response);
        this.getContact();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  
  public onDeleteContact(idContact: number): void {
    this.contactService.deleteContact(idContact).subscribe({
			next:(response: void) => {
      console.log(response);
      this.getContact();
      
    },
    error: (error: HttpErrorResponse) => {
      alert(error.message);
      
    }
  })
  
}


}