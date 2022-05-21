interface Doctor{
    name:string,
    age:number,
    gender:string,
    field:string
}
export class Patient{
    name:string;
    age:number;
    date:Date;
    doctor_id:Doctor;
    prescription:string;

    constructor(){
        this.name="";
        this.age=0;
        this.date=new Date("dd-mm-yyyy");
        this.doctor_id={} as Doctor;
        this.prescription="";
    }
}
