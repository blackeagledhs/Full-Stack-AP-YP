export class User {
    iduser: number;
    name: string;
    surname: string;
    title: string;
    urlImgprofile: string;
    urlImgbanner: string;
    aboutme: string;

    constructor(idUser: number,name: string, surname: string, title: string, urlImgprofile:string, urlImgbanner: string, aboutme: string){
        this.iduser = idUser;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.urlImgprofile = urlImgprofile;
        this.urlImgbanner = urlImgbanner;
        this.aboutme = aboutme;
    }
}
