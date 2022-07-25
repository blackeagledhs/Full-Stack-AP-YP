import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactComponent } from './page/contact/contact.component';
import { EducationComponent } from './page/education/education.component';
import { ExperienceComponent } from './page/experience/experience.component';
import { FooterComponent } from './page/footer/footer.component';
import { HeaderComponent } from './page/header/header.component';
import { HomeComponent } from './page/home/home.component';
import { NotfoundComponent } from './page/notfound/notfound.component';
import { ProjectComponent } from './page/project/project.component';
import { SkillComponent } from './page/skill/skill.component';
import { TopbarComponent } from './page/topbar/topbar.component';
import { LoginComponent } from './page/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    EducationComponent,
    ExperienceComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    NotfoundComponent,
    ProjectComponent,
    SkillComponent,
    TopbarComponent,
    LoginComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
