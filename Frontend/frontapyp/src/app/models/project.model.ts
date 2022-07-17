export class Project {

    idproject: number;
    projectname: string;
    projectdescription: string;
    urlproject: string;
    urlimgproject: string;

    constructor(idProject: number,projectname: string,projectdescription: string,urlproject: string,urlimgproject: string) {
        this.idproject = idProject;
        this.projectname = projectname;
        this.projectdescription = projectdescription;
        this.urlproject = urlproject;
        this.urlimgproject = urlimgproject;
    }
    
}
