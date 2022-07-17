import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Skill } from 'src/app/models/skill.model';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  public skill: Skill[] = [];
  public editSkill: Skill | undefined;
  public deleteSkill: Skill | undefined;
  


  constructor(private skillService: SkillService) { }

  ngOnInit(): void {
    this.getSkill();
  }

  public getSkill():void {
    this.skillService.getSkill().subscribe(
      data => {
        this.skill = data;
      },
      error => {
        console.log(error);
      }
    )
  }

  public onOpenModal(mode: String, skill?: Skill): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('buttoon');
    //button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addSkillModal');
    } else if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteSkillModal');
      this.deleteSkill = skill;
    } else if (mode === 'edit') {
      button.setAttribute('data-target', '#editSkillModal');
      this.editSkill = skill;
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddSkill(addForm: NgForm): void {
    document.getElementById('addSkillModal')?.click();
    this.skillService.addSkill(addForm.value).subscribe({
      next: (_response: Skill) => {
        this.getSkill();
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onEditSkill(skill: Skill): void {
    this.skillService.editSkill(skill).subscribe(
      (response: Skill) => {
        console.log(response);
        this.getSkill();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  
  public onDeleteSkill(idSkill: number): void {
    this.skillService.deleteSkill(idSkill).subscribe({
			next:(response: void) => {
      console.log(response);
      this.getSkill();
      
    },
    error: (error: HttpErrorResponse) => {
      alert(error.message);
      
    }
  })
  
}


}