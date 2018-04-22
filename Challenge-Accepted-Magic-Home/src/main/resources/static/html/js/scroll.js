$(document).ready(function() {
    
    
    var nextBtn = $("#next-btn");
    // nextBtn.click(onNextBtn);
    
    var previousBtn = $("#previous-btn");
    previousBtn.click(onPreviousBtn);
    
    var sendBtn = $("#send-btn");
    // sendBtn.click(onSendBtn);
});

function onRegisterBtn(){
    var formParent = $("#form-parent");
    var homePage = $("#home-page");
    formParent.removeClass("hide").addClass("show");
    homePage.removeClass("show").addClass("hide");
}

// function onNextBtn(){
//     var formChild = $("#child-form");
//     var formParent = $("#form-parent");
//     formChild.removeClass("hide").addClass("show");
//     formParent.removeClass("show").addClass("hide");
// }

function onPreviousBtn(){
    var formParent = $("#form-parent");
    var formChild = $("#child-form");
    formParent.removeClass("hide").addClass("show");
    formChild.removeClass("show").addClass("hide");
}

// function onSendBtn(){
//     var formChild = $("#child-form");
//     formChild.removeClass("show").addClass("hide");
//     var homePage = $("#home-page");
//     homePage.removeClass("hide").addClass("show");
//     var alertId = $("#alert-id");
//     alertId.removeClass("hide").addClass("show");
//     setTimeout(deletePopUp, 3000);
// }

// function deletePopUp(){
//     var alertId = $("#alert-id");
//     alertId.removeClass("show").addClass("hide");
// }

