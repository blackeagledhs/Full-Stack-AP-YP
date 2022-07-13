import { Component, OnInit } from '@angular/core';
import { Education } from 'src/app/models/education.model';
import { HttpErrorResponse } from '@angular/common/http';
import { EducationService } from '../../service/education.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  public education: Education[] = [];
  public editEducation: Education | undefined;
  public deleteEducation: Education | undefined;
  


  constructor(private educationService: EducationService) { }

  ngOnInit(): void {
    this.getEducation();
  }

  public getEducation():void {
    this.educationService.getEducation().subscribe(
      data => {
        this.education = data;
      },
      error => {
        console.log(error);
      }
    )
  }

  public onOpenModal(mode: String, education?: Education): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('buttoon');
    //button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEducationModal');
    } else if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteEducationModal');
      this.deleteEducation = education;
    } else if (mode === 'edit') {
      button.setAttribute('data-target', '#editEducationModal');
      this.editEducation = education;
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddEducation(addForm: NgForm): void {
    document.getElementById('addEducationModal')?.click();
    this.educationService.addEducation(addForm.value).subscribe({
      next: (_response: Education) => {
        this.getEducation();
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onEditEducation(education: Education): void {
    this.educationService.editEducation(education).subscribe(
      (response: Education) => {
        console.log(response);
        this.getEducation();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  
  public onDeleteEducation(idEducation: number): void {
    this.educationService.deleteEducation(idEducation).subscribe({
			next:(response: void) => {
      console.log(response);
      this.getEducation();
      
    },
    error: (error: HttpErrorResponse) => {
      alert(error.message);
      
    }
  })
  
}


}