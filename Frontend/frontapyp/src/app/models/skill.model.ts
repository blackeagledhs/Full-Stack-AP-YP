export class Skill {

    idskill: number;
    skill: string;
    percentage: string;

    constructor(idSkill: number, skill: string, percentage: string){
        this.idskill = idSkill;
        this.skill = skill;
        this.percentage = percentage;
    }
}
