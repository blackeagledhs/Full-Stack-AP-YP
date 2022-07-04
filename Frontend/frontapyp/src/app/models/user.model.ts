export class User {
    id?: number;
    name: string;
    surname: string;
    title: string;
    urlImgprofile: string;
    urlImgbanner: string;
    aboutme: string;

    constructor(name: string, surname: string, title: string, urlImgprofile: string, urlImgbanner: string, aboutme: string){
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.urlImgprofile = urlImgprofile;
        this.urlImgbanner = urlImgbanner;
        this.aboutme = aboutme;
    }
}
