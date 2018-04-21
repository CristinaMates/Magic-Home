window.addEventListener("load",function(){
    var list= new List;

list.getList()
.then(display);

function display(element){
    for (var i=0;i<=element.length;i++){
        displayElements(element[i]);
    }
    console.log(element);
}

var template=document.getElementById("template");


function displayElements(element){
    var templateClone=template.cloneNode(true);
    console.log(element);
    var nameParent=document.querySelector(".nameParent");
    nameParent.innerHTML+=element.custodian;
    var phoneNumber=document.querySelector(".phoneNumber");
    var nrPerson=document.querySelector(".nrPerson");
    nrPerson.innerHTML+=element.numberOfCustodians;
    var date=document.querySelector(".date");
    var days=document.querySelector(".days");
    var nameChild=document.querySelector(".nameChild");
    nameChild.innerHTML+=element.patient;
    var diagnostic=document.querySelector(".diagnostic");
    var varsta=document.querySelector("#varsta");
    var disability=document.querySelector(".disability");
    var doctor=document.querySelector(".doctor");
    var psycho =document.querySelector(".psiholog");
    
    var buttonDenie=templateClone.querySelector(".deniedButton");
    buttonDenie.addEventListener("click",function(event){
    
    });
    var buttonAccept=templateClone.querySelector(".acceptButton"); 
    buttonAccept.addEventListener("click",function(event){
    console.log(event);
    });
}


})
