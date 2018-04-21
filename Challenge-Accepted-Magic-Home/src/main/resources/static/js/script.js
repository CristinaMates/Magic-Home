 window.addEventListener("load",function(){

    var registerBtn = $("#register-btn");
    registerBtn.click(onRegisterBtn);
    var previousBtn = $("#previous-btn");
    previousBtn.click(onPreviousBtn);
$( function() {
    $( "#datepicker" ).datepicker();
  } );
 
var errorParent=$("#errorParent");
var nextButton=document.getElementsByClassName("btnNext")[0];
var submitButton=document.getElementsByClassName("submitButton")[0];
console.log(nextButton);
   nextButton.addEventListener("click",function(){
       if (validFormParent()){
           errorParent.html("OK");
           onNextBtn();
       }
       else{
           errorParent.html("Campuri goale");
        }
        })
    submitButton.addEventListener("click",function(){
        var x=validFormChild();
        if (x===true){
            console.log(validFormChild());
            onSubmitBtn();
        }
        //      else {
        //     console.log("blah");
        // } 
        });
});

function validFormParent() {

    var fnameParent=document.getElementById("fNameParent");
    var lnameParent=document.getElementById("lNameParent");
    var telefon=document.getElementById("telefon");
    var selectNumber=document.getElementById("inputNumber");
    var calendarVal=document.getElementById("inputDays");
    var datepicker=document.getElementById("datepicker");
    console.log(datepicker);
    console.log(calendarVal);
    var ok=true;
    if (fnameParent.value=='' || !allLetter(fnameParent)){
        fnameParent.style.border="solid 1px red";
        ok=false;
    }else{
        fnameParent.style.border="";
        
    }
    if (lnameParent.value==''|| !allLetter(lnameParent)){
        lnameParent.style.border="solid 1px red";
        ok=false;
    }else{
        lnameParent.style.border="";
    }
    if (telefon.value=='' || telefon.value.length!=10 || isNaN(telefon.value)){
        telefon.style.border="solid 1px red";
        ok=false;
    }else{
        telefon.style.border="";
    }
    if (calendarVal.value=='' || isNaN(calendarVal.value)){
        calendarVal.style.border="solid 1px red";
        ok=false;
    }else{
         calendarVal.style.border="";
    }
    if (datepicker.value==''){
        datepicker.style.border="solid 1px red";
        ok=false;
    }else{
        datepicker.style.border="";
    }
   
    return ok;
}
function allLetter(inputtxt){ 
      var letters = /^[A-Za-z]+$/;
      if(inputtxt.value.match(letters))
      {
     
      return true;
      }
      else
      {
     
      return false;
      }
      }
function validFormChild(){
    var fnameChild=document.getElementById("fNameChild");
    var lnameChild=document.getElementById("lNameChild");
    var diagnoza=document.getElementById("diagnoza");
    var varsta=document.getElementById("varsta");
    var ok=true;
    if (fnameChild.value==''|| !allLetter(fnameChild)){
        fnameChild.style.border="solid 1px red";
        ok=false;
    }else{
        fnameChild.style.border="";
    }
    if (lnameChild.value==''|| !allLetter(lnameChild)){
       lnameChild.style.border="solid 1px red"; 
       ok=false;
    }else{
        lnameChild.style.border="";
    }
    if(diagnoza.value==''){
        diagnoza.style.border="solid 1px red";
        ok=false;
    }else{
        diagnoza.style.border=""
    }
    if (varsta.value==''|| isNaN(varsta.value)){
        varsta.style.border="solid 1px red";
        ok=false;
    }else{
        varsta.style.border=""
    }
    return ok;
}
function onSubmitBtn(){
    var formChild = $("#child-form");
    formChild.removeClass("show").addClass("hide");
    var homePage = $("#home-page");
    homePage.removeClass("hide").addClass("show");
    var alertId = $("#alert-id");
    alertId.removeClass("hide").addClass("show");
    setTimeout(deletePopUp, 3000);
}
function deletePopUp(){
    var alertId = $("#alert-id");
    alertId.removeClass("show").addClass("hide");
}
function onNextBtn(){
    var formChild = $("#child-form");
    var formParent = $("#form-parent");
    formChild.removeClass("hide").addClass("show");
    formParent.removeClass("show").addClass("hide");
}
function onRegisterBtn(){
    var formParent = $("#form-parent");
    var homePage = $("#home-page");
    formParent.removeClass("hide").addClass("show");
    homePage.removeClass("show").addClass("hide");
}
function onPreviousBtn(){
    var formParent = $("#form-parent");
    var formChild = $("#child-form");
    formParent.removeClass("hide").addClass("show");
    formChild.removeClass("show").addClass("hide");
}

