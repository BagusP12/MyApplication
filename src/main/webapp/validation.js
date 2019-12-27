/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validatePhone() {
    var mobile = document.forms["form1"]["mobile"].value;
    var mobileformat = /()?(\+62|62|0)(\d{2,3})?\)?[ .-]?\d{2,4}[ .-]?\d{2,4}[ .-]?\d{2,4}/;
    if (mobile == "") {
        alert("Mobile phone is required");
        return false;
    } else {
        if(mobile.match(mobileformat)) {
            return true;
        } else {
            alert("Mobile phone number must be Indonesian phone number")
            return false;
        }
    }
}

function validateFirstname() {
    var firstname = document.forms["form1"]["firstname"].value;
    if(firstname == "") {
        alert("First name is required");
        return false;
    }
}

function validateLastname() {
    var lastname = document.forms["form1"]["lastname"].value;
    if(lastname == "") {
        alert("Last name is required");
        return false;
    }
}

function validateEmail() {
    var email = document.forms["form1"]["email"].value;
    var mailformat = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email == "") {
        alert("Email is required");
        return false;
    } else {
        if(mailformat.test(email)) {
            return true;
        } else {
            alert("You have entered an invalid email address!");
            return false;
        }
    }
}
