export class Education {
    ideducation: number;
    institute: string;
    certificate: string;
    year: string;

    constructor(idEducation: number,institute:string,certificate: string,year: string) {        
        this.ideducation = idEducation;
        this.institute = institute;
        this.certificate = certificate;
        this.year = year;
    }

}
