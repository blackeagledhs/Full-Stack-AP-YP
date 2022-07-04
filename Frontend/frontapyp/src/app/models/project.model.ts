export class Project {

    idproject: number;
    projectname: string;
    projectdescription: string;
    urlproject: string;
    urlimgproject: string;

    constructor(idproject: number,projectname: string,projectdescription: string,urlproject: string,urlimgproject: string) {
        this.idproject = idproject;
        this.projectname = projectname;
        this.projectdescription = projectdescription;
        this.urlproject = urlproject;
        this.urlimgproject = urlimgproject;
    }
    
}
