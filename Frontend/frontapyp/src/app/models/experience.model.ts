export class Experience {
    idexperience: number;
    company: string;
    description: string;
    admission: string;
    egress: string;

    constructor(idExperience: number, company: string, description: string,admission: string, egress: string){
        this.idexperience = idExperience;
        this.company = company;
        this.description = description;
        this.admission = admission;
        this.egress = egress;
    }
    
}
