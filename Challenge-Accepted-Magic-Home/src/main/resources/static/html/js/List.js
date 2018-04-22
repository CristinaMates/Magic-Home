function List(){
    this.costudian="";
    this.patient="";
    this.numberOfCostudian="";
    this.doctor="";
    this.entranceDate="";
    this.days="";
    this.needsPsychologicalCouseling=false;
    this.phoneNumber="";
    this.diagnostic="";
    this.age="";
    this.disability=false;
}
/*
{
    "custodian": {
        "firstName": "Tata",
        "lastName": "Lui Georgel",
        "telephone": "40724251112",
    },
    "patient": {
        "firstName": "Georgel",
        "lastName": "Popesu",
        "diagnosis": "hepatita",
        "age": 10,
        "doctor": null,
        "disability": false
    },
    "numberOfCustodians": 0,
    "doctor": {
        "firstName": "Doctor",
        "lastName": "Costel",
    },
    "entranceDate": 1524318137657,
    "days": 5,
    "needsPsychologicalCounseling": false,

*/
List.prototype.sendData=function(newElement){

      var fnameParent=document.getElementById("fNameParent");
       var lnameParent=document.getElementById("lNameParent");
       var telefon=document.getElementById("telefon");
       var selectNumber=document.getElementById("inputNumber");
       var calendarVal=document.getElementById("inputDays");
       var datepicker=document.getElementById("datepicker");
        var fnameChild=document.getElementById("fNameChild");
           var lnameChild=document.getElementById("lNameChild");
           var diagnoza=document.getElementById("diagnoza");
           var varsta=document.getElementById("varsta");

    var data = JSON.stringify(
     {

                     "custodian": {
                         "firstName": fnameParent.value,
                         "lastName": lnameParent.value,
                         "telephone": telefon.value
                     },
                     "patient": {
                         "firstName": fnameChild.value,
                         "lastName": lnameChild.value,
                         "diagnosis": diagnoza.value,
                         "age": varsta.value

                     },
                     "doctor": {
                         "firstName": "Doctor",
                         "lastName": "Costel"
                     },
                     "entranceDate": 1524318137657,
                     "days": 5,
                     "needsPsychologicalCounseling": false


             });
    return $.ajax({
        url:"http://localhost:8080/api/reservation",
        method:'POST',
        contentType: "application/json",
        data:data

        });
        
    }

List.prototype.getList=function(){
return $.ajax({
    url:"http://localhost:8080/api/reservation",
    method:"GET",
    
    
})
}

