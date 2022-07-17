import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Experience } from 'src/app/models/experience.model';
import { ExperienceService } from 'src/app/service/experience.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  public experience: Experience[] = [];
  public editExperience: Experience | undefined;
  public deleteExperience: Experience | undefined;
  


  constructor(private experienceService: ExperienceService) { }

  ngOnInit(): void {
    this.getExperience();
  }

  public getExperience():void {
    this.experienceService.getExperience().subscribe(
      data => {
        this.experience = data;
      },
      error => {
        console.log(error);
      }
    )
  }

  public onOpenModal(mode: String, experience?: Experience): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    //button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addExperienceModal');
    } else if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteEducationModal');
      this.deleteExperience = experience;
    } else if (mode === 'edit') {
      button.setAttribute('data-target', '#editExperienceModal');
      this.editExperience = experience;
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddExperience(addForm: NgForm): void {
    document.getElementById('addExperienceModal')?.click();
    this.experienceService.addExperience(addForm.value).subscribe({
      next: (_response: Experience) => {
        this.getExperience();
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onEditExperience(experience: Experience): void {
    this.experienceService.editExperience(experience).subscribe(
      (response: Experience) => {
        console.log(response);
        this.getExperience();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  
  public onDeleteExperience(idExperience: number): void {
    this.experienceService.deleteExperience(idExperience).subscribe({
			next:(response: void) => {
      console.log(response);
      this.getExperience();
      
    },
    error: (error: HttpErrorResponse) => {
      alert(error.message);
      
    }
  })
  
}


}