import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Project } from 'src/app/models/project.model';
import { ProjectService } from 'src/app/service/project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  public project: Project[] = [];
  public editProject: Project | undefined;
  public deleteProject: Project | undefined;
  


  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.getProject();
  }

  public getProject():void {
    this.projectService.getProject().subscribe(
      data => {
        this.project = data;
      },
      error => {
        console.log(error);
      }
    )
  }

  public onOpenModal(mode: String, project?: Project): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('buttoon');
    //button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addProjectModal');
    } else if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteProjectModal');
      this.deleteProject = project;
    } else if (mode === 'edit') {
      button.setAttribute('data-target', '#editProjectModal');
      this.editProject = project;
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddProject(addForm: NgForm): void {
    document.getElementById('addProjectModal')?.click();
    this.projectService.addProject(addForm.value).subscribe({
      next: (_response: Project) => {
        this.getProject();
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onEditProject(project: Project): void {
    this.projectService.editProject(project).subscribe(
      (response: Project) => {
        console.log(response);
        this.getProject();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  
  public onDeleteProject(idProject: number): void {
    this.projectService.deleteProject(idProject).subscribe({
			next:(response: void) => {
      console.log(response);
      this.getProject();
      
    },
    error: (error: HttpErrorResponse) => {
      alert(error.message);
      
    }
  })
  
}


}