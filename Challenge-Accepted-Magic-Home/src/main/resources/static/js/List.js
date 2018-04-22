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
List.prototype.sendData=function(newElement){
    return $.ajax({
        url:"http://localhost:8080/api/reservation",
        method:'POST',
        data:{
            "costudian.firstName":"ana",
            "patient": "sebi",
            "numberOfCostudian": "0",
            "doctor":"doctor",
            "entranceDate":"2018-02-03",
            "days":3,
            "needsPsychologicalCouseling":false,
        }
    }
        ).then(function(response){
            console.log(response);
        })
        
    }

List.prototype.getList=function(){
return $.ajax({
    url:"http://localhost:8080/api/reservation",
    method:"GET",
    
    
})
}

