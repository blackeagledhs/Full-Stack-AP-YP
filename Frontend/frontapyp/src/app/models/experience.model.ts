export class Experience {
    idexperience: number;
    company: string;
    description: string;
    admission: string;
    egress: string;

    constructor(idexperience: number, company: string, description: string,admission: string, egress: string){
        this.idexperience = idexperience;
        this.company = company;
        this.description = description;
        this.admission = admission;
        this.egress = egress;
    }
    
}
