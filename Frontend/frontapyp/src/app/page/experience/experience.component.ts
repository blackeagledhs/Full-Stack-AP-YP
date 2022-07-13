import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { Experience } from 'src/app/models/experience.model';
import { ExperienceService } from 'src/app/service/experience.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  experiences: Experience[] = [];
  

  constructor(
    private experienceService: ExperienceService) { }

  ngOnInit(): void {
    this.getExperience();
  }

  getExperience(): void {
    this.experienceService.getExperiences().subscribe(
      data => {
        this.experiences = data;
      },
      err => {
        console.log(err);
      }
    )
  }

  onDeleteExperience(idExperience: number):any {
    this.experienceService.deleteExperience(idExperience).subscribe({
			next:(response: any) => {
      console.log(response);
      this.getExperience();
      
    },
    error:(error: HttpErrorResponse) => {
      alert(error.message);
      
    }
  })
  
}
}
