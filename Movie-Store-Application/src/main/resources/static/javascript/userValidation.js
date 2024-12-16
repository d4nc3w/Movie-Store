document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const firstNameInput = document.getElementById("firstName");
    const lastNameInput = document.getElementById("lastName");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");

    form.addEventListener("submit", (event) => {
        let isValid = true;
        let firstName_error = document.querySelector('#firstName_error');
        let lastName_error = document.querySelector('#lastName_error');
        let email_error = document.querySelector('#email_error');
        let password_length_error = document.querySelector('#password_length_error');
        let password_digit_error = document.querySelector('#password_digit_error');
        let password_uppercase_error = document.querySelector('#password_uppercase_error');
        let anyError = document.getElementById("anyError");

        if(!/^\s*[A-Z]/.test(firstNameInput.value)){
            isValid = false;
            firstNameInput.classList.add("error");
            firstName_error.innerText = 'First name should start with uppercase';
        } else {
            firstNameInput.classList.remove("error");
            firstName_error.innerText = '';
        }

        if(!/^\s*[A-Z]/.test(lastNameInput.value)){
            isValid = false;
            lastNameInput.classList.add("error");
            lastName_error.innerText = 'Last name should start with uppercase';
        } else {
            lastNameInput.classList.remove("error");
            lastName_error.innerText = '';
        }

        if (!emailInput.value.includes("@")) {
            isValid = false;
            emailInput.classList.add("error");
            email_error.innerText = 'Email should contain "@"';
        } else {
            emailInput.classList.remove("error");
            email_error.innerText = '';
        }

        if (passwordInput.value.length < 8) {
            isValid = false;
            passwordInput.classList.add("error");
            password_length_error.innerText = 'Password should have at least 8 characters';
        } else {
            passwordInput.classList.remove("error");
            password_length_error.innerText = '';
        }

        if (!/\d/.test(passwordInput.value)) {
            isValid = false;
            passwordInput.classList.add("error");
            password_digit_error.innerText = 'Password should contain at least one digit';
        } else {
            passwordInput.classList.remove("error");
            password_digit_error.innerText = '';
        }

        if (!/[A-Z]/.test(passwordInput.value)) {
            isValid = false;
            passwordInput.classList.add("error");
            password_uppercase_error.innerText = 'Password should contain at least one uppercase letter';
        } else {
            passwordInput.classList.remove("error");
            password_uppercase_error.innerText = '';
        }

        if (!isValid) {
            event.preventDefault();
            anyError.innerText = "Correct all errors in order to submit.";
        } else {
            anyError.innerText = "";
        }

    });
});