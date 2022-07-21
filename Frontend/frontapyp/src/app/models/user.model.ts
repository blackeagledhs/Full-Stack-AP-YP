export class User {
    iduser: number;
    name: string;
    surname: string;
    title: string;
    urlimgprofile: string;
    urlimgbanner: string;
    aboutme: string;

    constructor(idUser: number,name: string, surname: string, title: string, urlImgprofile: string, urlImgbanner: string, aboutme: string){
        this.iduser = idUser;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.urlimgprofile = urlImgprofile;
        this.urlimgbanner = urlImgbanner;
        this.aboutme = aboutme;
    }
}
