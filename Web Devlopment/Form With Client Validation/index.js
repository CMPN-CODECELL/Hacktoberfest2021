const form = document.querySelector("form");

function validateForm(e){
    e.preventDefault();

    errors = [];

    const first_name = document.getElementById("first_name").value;
    
    if(first_name.length <= 1){
        errors.push("Length of first name is too short");
        document.getElementById("first-name-error").innerHTML = "*Length of first name is too short \n";
    }else{
        if (/^[a-zA-Z]*$/.test(first_name)){
            document.getElementById("first-name-error").innerHTML = "";
        }else{
            errors.push("First name should contain only alphabets");
            document.getElementById("first-name-error").innerHTML = "*First name should contain only alphabets";
        }
    }

    const last_name = document.getElementById("last_name").value;
    
    if(last_name.length <= 1){
        errors.push("Length of last name is too short");
        document.getElementById("last-name-error").innerHTML = "*Length of last name is too short";
    }else{
        if (/^[a-zA-Z]*$/.test(last_name)){
            document.getElementById("last-name-error").innerHTML = "";
        }else{
            errors.push("Last name should contain only alphabets");
            document.getElementById("last-name-error").innerHTML = "*Last name should contain only alphabets";
        }
    }

    const email = document.getElementById("email").value;

    if (/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email.toLowerCase())){
        document.getElementById("email-error").innerHTML = "";
    }
    else{
        errors.push("Enter valid email id");
        document.getElementById("email-error").innerHTML = "*Enter valid email id";
    }

    let password = document.getElementById("password").value.trim();

    if(password.length < 6){
        errors.push("Password can not be less than 6 characters");
        document.getElementById("password-error").innerHTML = "*Password can not be less than 6 characters";
    }
    else{
        document.getElementById("password-error").innerHTML = "";
    }

    let confirm_password = document.getElementById("confirm_password").value.trim();

    if(password != confirm_password){
        errors.push("Password do not match");
        document.getElementById("confirm-password-error").innerHTML = "*Password do not match";
    }
    else{
        document.getElementById("confirm-password-error").innerHTML = "";
    }
    

    if(!errors.length){
        alert("You have registered succesfully");
    }
}
form.addEventListener("submit", validateForm);