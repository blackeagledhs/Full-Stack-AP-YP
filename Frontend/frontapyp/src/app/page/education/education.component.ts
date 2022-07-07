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

  public education: Education[]=[];
  public editEducation: Education | undefined;
  public deleteEducation: Education | undefined;
  


  constructor(private educationService: EducationService) { }

  ngOnInit(): void {
    this.getEducation();
  }

  public getEducation():void {
    this.educationService.getEducation().subscribe({
      next:(response: Education[]) => {
        this.education = response;
      },
      error:(error: HttpErrorResponse) => {
        alert(error.message);
      }

      })
    }

    public onAddEducation(addForm: NgForm):void {
      document.getElementById('add-estudios-modal')?.click();
      this.educationService.addEducation(addForm.value).subscribe({
        next:(response: Education) => {
          console.log(response);
          this.getEducation();
          addForm.reset();
        },
        error:(error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }

      })
    }

    public onEditEducation(education: Education):void {
		  this.educationService.editEducation(education).subscribe({
			next:(response: Education) => {
			console.log(response);
			this.getEducation();
			
		  },
		  error:(error: HttpErrorResponse) => {
			alert(error.message);
		  }
		  
		})
    }

    public onDeleteEducation(idEducation: number):void {
      this.educationService.deleteEducation(idEducation).subscribe({
        next:(response: void) => {
        console.log(response);
        this.getEducation();
        
      },
      error:(error: HttpErrorResponse) => {
        console.log(error.message);
      }
    })
    
  }
  /**Modal */
  public onOpenModal(mode: string, education?: Education): void{
    const container = document.getElementById('cero');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEducationModal');
    }

    if (mode === 'edit') {
      this.editEducation = education;
      button.setAttribute('data-target', '#updateEducationModal');
    }
  
  
    if (mode === 'delete') {
      this.deleteEducation = education;
      button.setAttribute('data-target', '#deleteEducacionModal');
    }
  /*
  
    */
    container?.appendChild(button);
    button.click();
  }




  }




